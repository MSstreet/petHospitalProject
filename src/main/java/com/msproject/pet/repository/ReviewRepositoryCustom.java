package com.msproject.pet.repository;

import com.msproject.pet.entity.ReviewEntity;
import com.msproject.pet.model.SearchCondition;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.msproject.pet.entity.QReviewEntity.reviewEntity;

@RequiredArgsConstructor
@Repository
public class ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public Page<ReviewEntity> findAllBySearchCondition(Pageable pageable, SearchCondition searchCondition, Long id) {


        JPAQuery<ReviewEntity> query = queryFactory.selectFrom(reviewEntity)
                .where(reviewEntity.petHospitalEntity.hospitalId.eq(id), reviewEntity.deleteYn.eq(false), reviewEntity.approveYn.eq(true));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        System.out.println("!!!!!!!!total!!!!!!!!!!!!!!!!!!!!!" + total);

        List<ReviewEntity> results = query
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(reviewEntity.reviewId.desc())
                .fetch();

       System.out.println("222resultSize : " + results.size());
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ : " + pageable.getPageSize());
        return new PageImpl<>(results, pageable, total);
    }


    public Page<ReviewEntity> findAllByUserId(Pageable pageable, SearchCondition searchCondition, Long id) {

//        JPAQuery<ReviewEntity> query = queryFactory.selectFrom(reviewEntity)
//                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()));

        JPAQuery<ReviewEntity> query = queryFactory.selectFrom(reviewEntity)
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()),  reviewEntity.deleteYn.eq(false))
                .where(reviewEntity.userEntity.idx.eq(id));

        long total = query.stream().count();   //여기서 전체 카운트 후 아래에서 조건작업

        List<ReviewEntity> results = query
                .where(searchKeywords(searchCondition.getSk(), searchCondition.getSv()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(reviewEntity.reviewId.desc())
                .fetch();

//        System.out.println("222resultSize : " + results.size());

        return new PageImpl<>(results, pageable, total);
    }


    private BooleanExpression searchKeywords(String sk, String sv) {

        if ("name".equals(sk)) {
            if (StringUtils.hasLength(sv)) {
                return reviewEntity.content.contains(sv);
            }
        }
        return null;
    }
//        } else if ("addr".equals(sk)) {
//            if (StringUtils.hasLength(sv)) {
//                return petHospitalEntity.hospitalAddr.contains(sv);
//            }
//        }

//        } else if ("contents".equals(sk)) {
//            if(StringUtils.hasLength(sv)) {
//                return petHospitalEntity.hospitalId.contents.contains(sv);
//            }
//        }

    public double getReviewAvg(Long id) {
//        BooleanExpression deleteCondition = reviewEntity.deleteYn.eq(false);
//        BooleanExpression approveCondition = reviewEntity.approveYn.eq(true);
//        BooleanExpression combinedCondition = deleteCondition.and(approveCondition);
//
//        JPAQuery<ReviewEntity> query = queryFactory.select(reviewEntity).where(reviewEntity.petHospitalEntity.hospitalId.eq(id).and(reviewEntity.deleteYn.eq(false)));
//        JPAQuery<Double> score1 = query.select(reviewEntity.score.avg()).from(reviewEntity);;

        JPAQuery<Double> score = queryFactory.select(reviewEntity.score.avg()).where(reviewEntity.petHospitalEntity.hospitalId.eq(id).and(reviewEntity.deleteYn.eq(false)).and(reviewEntity.approveYn.eq(true))).from(reviewEntity);

        double results;
        if(score.fetchOne() == null){
            return 0;
        }else{
            results = score.fetchOne();
            return results;
        }

//        double results1;
//        if(score1.fetchOne() == null){
//            return 0;
//        }else{
//            results1 = score1.fetchOne();
//            return results1;
//        }

    }
}
