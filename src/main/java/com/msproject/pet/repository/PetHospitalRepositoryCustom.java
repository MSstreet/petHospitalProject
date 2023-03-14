package com.msproject.pet.repository;

import com.msproject.pet.entity.PetHospitalEntity;
import com.msproject.pet.model.SearchCondition;
import com.msproject.pet.web.dtos.PetHospitalListReviewCountDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.SubQueryExpression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.msproject.pet.entity.QPetHospitalEntity.petHospitalEntity;
import static com.msproject.pet.entity.QReviewEntity.reviewEntity;

@RequiredArgsConstructor
@Repository
public class PetHospitalRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public Page<PetHospitalListReviewCountDto> findAllBySearchConditionWithReviewCount(Pageable pageable, SearchCondition searchCondition){

        JPAQuery<PetHospitalEntity> query = queryFactory.selectFrom(petHospitalEntity)
                .leftJoin(reviewEntity).on(reviewEntity.petHospitalEntity.eq(petHospitalEntity));

        query.where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()),petHospitalEntity.operState.contains("정상"));
        query.groupBy(petHospitalEntity);

        long total = query.stream().count();

        List<PetHospitalEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()),petHospitalEntity.operState.contains("정상"))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(reviewEntity.score.avg().desc())
                .fetch();

        JPAQuery<PetHospitalListReviewCountDto> dtoJPAQuery = query.select(Projections.bean(PetHospitalListReviewCountDto.class,
        petHospitalEntity.hospitalId,
                petHospitalEntity.hospitalName,
                petHospitalEntity.sigunName,
                petHospitalEntity.operState,
                petHospitalEntity.hospitalNum,
                petHospitalEntity.hospitalAddr,
                //petHospitalEntity.petHospitalScore,
                reviewEntity.count().as("reviewCount")
                //reviewEntity.deleteYn.eq(false).count().as("reviewCount")
        ));

        List<PetHospitalListReviewCountDto> dtoList = dtoJPAQuery.fetch();

        //long count = dtoJPAQuery.stream().count();

        return new PageImpl<>(dtoList, pageable, total);
    }

    public PetHospitalListReviewCountDto findWithReviewCountById(Long id){

        JPAQuery<PetHospitalEntity> query = queryFactory.selectFrom(petHospitalEntity)
                .leftJoin(reviewEntity).on(reviewEntity.petHospitalEntity.eq(petHospitalEntity))
                .where(petHospitalEntity.hospitalId.eq(id).and(reviewEntity.deleteYn.eq(false)).and(reviewEntity.approveYn.eq(true)));

        JPAQuery<PetHospitalListReviewCountDto> dtoJPAQuery = query.select(Projections.bean(PetHospitalListReviewCountDto.class,
                petHospitalEntity.hospitalId,
                petHospitalEntity.hospitalName,
                petHospitalEntity.sigunName,
                petHospitalEntity.operState,
                petHospitalEntity.hospitalNum,
                petHospitalEntity.hospitalAddr,
               // petHospitalEntity.petHospitalScore,
                petHospitalEntity.hosLatitude,
                petHospitalEntity.hosLongitude,
                reviewEntity.count().as("reviewCount")
        ));

        PetHospitalListReviewCountDto dto = dtoJPAQuery.fetchOne();

        return dto;
    }


    public Page<PetHospitalEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition) {

        JPAQuery<PetHospitalEntity> query = queryFactory.selectFrom(petHospitalEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<PetHospitalEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()),petHospitalEntity.operState.contains("정상"))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(petHospitalEntity.hospitalId.desc())
                .fetch();

        System.out.println("222resultSize : " + results.size());

        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sk, String sv) {

        System.out.println("확인!!!" + sk);
        System.out.println("확인!!!" + sv);

        if("author".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return petHospitalEntity.hospitalName.contains(sv);
            }
        } else if ("title".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return petHospitalEntity.hospitalAddr.contains(sv);
            }
        }

//        } else if ("contents".equals(sk)) {
//            if(StringUtils.hasLength(sv)) {
//                return petHospitalEntity.hospitalId.contents.contains(sv);
//            }
//        }

        return null;
    }

    private BooleanExpression searchKeywords1( String sv) {
        System.out.println("확인!!!" + sv);

            if(StringUtils.hasLength(sv)) {
                return petHospitalEntity.hospitalAddr.contains(sv);
            }

//        } else if ("contents".equals(sk)) {
//            if(StringUtils.hasLength(sv)) {
//                return petHospitalEntity.hospitalId.contents.contains(sv);
//            }
//        }
        return null;
    }

    public Page<PetHospitalListReviewCountDto> findAllBySearchConditionWithReviewCount1(Pageable pageable, SearchCondition searchCondition) {

        JPAQuery<PetHospitalEntity> query = queryFactory.selectFrom(petHospitalEntity)
                .leftJoin(reviewEntity).on(reviewEntity.petHospitalEntity.eq(petHospitalEntity));

        query.where(searchKeywords1(searchCondition.getSv()),petHospitalEntity.operState.contains("정상"));

        query.groupBy(petHospitalEntity);

        long total = query.stream().count();

        //System.out.println("total : " + total);

        List<PetHospitalEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()),petHospitalEntity.operState.contains("정상"))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(petHospitalEntity.hospitalId.desc())
                .fetch();

        //System.out.println("resultSize : " + results.size());

        JPAQuery<PetHospitalListReviewCountDto> dtoJPAQuery = query.select(Projections.bean(PetHospitalListReviewCountDto.class,
                petHospitalEntity.hospitalId,
                petHospitalEntity.hospitalName,
                petHospitalEntity.sigunName,
                petHospitalEntity.operState,
                petHospitalEntity.hospitalNum,
                petHospitalEntity.hospitalAddr,
                //petHospitalEntity.petHospitalScore,
                reviewEntity.count().as("reviewCount")
        ));

        List<PetHospitalListReviewCountDto> dtoList = dtoJPAQuery.fetch();

        //long count = dtoJPAQuery.stream().count();

        return new PageImpl<>(dtoList, pageable, total);

    }
}
