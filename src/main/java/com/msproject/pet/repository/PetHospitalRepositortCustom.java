package com.msproject.pet.repository;

import com.msproject.pet.entity.PetHospitalEntity;
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

import static com.msproject.pet.entity.QPetHospitalEntity.petHospitalEntity;

@RequiredArgsConstructor
@Repository
public class PetHospitalRepositortCustom {

    private final JPAQueryFactory queryFactory;

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

        return new PageImpl<>(results, pageable, total);
    }

    private BooleanExpression searchKeywords(String sk, String sv) {

        if("name".equals(sk)) {
            if(StringUtils.hasLength(sv)) {
                return petHospitalEntity.hospitalName.contains(sv);
            }
        } else if ("addr".equals(sk)) {
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
}
