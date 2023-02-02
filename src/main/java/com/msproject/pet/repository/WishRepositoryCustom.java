package com.msproject.pet.repository;


import com.msproject.pet.entity.WishEntity;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;


import static com.msproject.pet.entity.QWishEntity.wishEntity;

import static com.msproject.pet.entity.QUserEntity.userEntity;
import static com.msproject.pet.entity.QPetHospitalEntity.petHospitalEntity;


@RequiredArgsConstructor
@Repository
public class WishRepositoryCustom {

    private final JPAQueryFactory queryFactory;


    public Page<WishEntity> findAllReview(Pageable pageable, Long userId, Long hosId) {

        JPAQuery<WishEntity> query = queryFactory.selectFrom(wishEntity)
                .where(wishEntity.petHospitalEntity.hospitalId.eq(hosId).and(wishEntity.userEntity.idx.eq(userId)));

        long total = query.stream().count();

        List<WishEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(wishEntity.wishId.desc())
                .fetch();

        return new PageImpl<>(results, pageable, total);
    }
}