package com.msproject.pet.entity;

import com.msproject.pet.model.SearchCondition;
import com.msproject.pet.web.dtos.BoardListWithReplyCountDto;
import com.msproject.pet.web.dtos.PetHospitalListReviewCountDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.msproject.pet.entity.QBoardEntity.boardEntity;
import static com.msproject.pet.entity.QBoardReply.boardReply;
import static com.msproject.pet.entity.QPetHospitalEntity.petHospitalEntity;
import static com.msproject.pet.entity.QReviewEntity.reviewEntity;

@RequiredArgsConstructor
@Repository
public class BoardRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    public Page<BoardEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {

        JPAQuery<BoardEntity> query = queryFactory.selectFrom(boardEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()), boardEntity.deleteYn.eq(false));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<BoardEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(boardEntity.idx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    public Page<BoardListWithReplyCountDto> findAllBySearchConditionWithReplyCount(Pageable pageable,SearchCondition searchCondition) {

        JPAQuery<BoardEntity> query = queryFactory.selectFrom(boardEntity)
                .leftJoin(boardReply).on(boardReply.boardEntity.eq(boardEntity));

        query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()),boardEntity.deleteYn.eq(false));
        query.groupBy(boardEntity);

        long total = query.stream().count();
        //System.out.println("total : " + total);

        List<BoardEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                //.orderBy(petHospitalEntity.hospitalId.desc())
                .orderBy(boardEntity.idx.desc())
                //.orderBy(reviewEntity.score.avg().when(reviewEntity.deleteYn.eq(false)))
                .fetch();

        JPAQuery<BoardListWithReplyCountDto> dtoJPAQuery = query.select(Projections.bean(BoardListWithReplyCountDto.class,
                boardEntity.idx,
                boardEntity.title,
                boardEntity.contents,
                boardEntity.author,
                boardEntity.userEntity.idx.as("userIdx"),
                boardEntity.userEntity.userId,
                boardEntity.createdAt,
                boardEntity.updatedAt,
                boardReply.count().as("replyCount")
        ));

        List<BoardListWithReplyCountDto> dtoList = dtoJPAQuery.fetch();

        //long count = dtoJPAQuery.stream().count();

        return new PageImpl<>(dtoList, pageable, total);
    }

    private BooleanExpression searchKeywords(String sk, String sv) {
        if("author".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return boardEntity.author.contains(sv);
            }
        } else if ("title".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return boardEntity.title.contains(sv);
            }
        } else if ("contents".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return boardEntity.contents.contains(sv);
            }
        }

        return null;
    }


}
