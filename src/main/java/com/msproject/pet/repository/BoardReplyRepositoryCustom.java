package com.msproject.pet.repository;

import com.msproject.pet.entity.BoardReply;
import com.msproject.pet.entity.ReviewEntity;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;


import static com.msproject.pet.entity.QBoardReply.boardReply;
import static com.msproject.pet.entity.QBoardEntity.boardEntity;


@RequiredArgsConstructor
@Repository
public class BoardReplyRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public Page<BoardReply> findAllBySearchCondition(Pageable pageable, Long id) {

        JPAQuery<BoardReply> query = queryFactory.selectFrom(boardReply)
                .where(boardReply.boardEntity.idx.eq(id), boardReply.deleteYn.eq(false));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<BoardReply> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(boardReply.replyIdx.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }
}
