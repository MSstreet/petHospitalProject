package com.msproject.pet.repository;

import com.msproject.pet.entity.BoardEntity;
import com.msproject.pet.entity.NoticeBoard;
import com.msproject.pet.model.SearchCondition;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.msproject.pet.entity.QBoardEntity.boardEntity;
import static com.msproject.pet.entity.QNoticeBoard.noticeBoard;

@RequiredArgsConstructor
@Repository
public class NoticeBoardRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public Page<NoticeBoard> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {

        JPAQuery<NoticeBoard> query = queryFactory.selectFrom(noticeBoard)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()),noticeBoard.display_yn.eq(true));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<NoticeBoard> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(noticeBoard.nboardId.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sk, String sv) {
//        if("author".equals(sk)) {
//            if(StringUtils.hasLength(sv)) {
//                return boardEntity.author.contains(sv);
//            }
//        }
        if ("title".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return noticeBoard.title.contains(sv);
            }
        } else if ("contents".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return noticeBoard.contents.contains(sv);
            }
        }
        return null;
    }
}
