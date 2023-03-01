package com.msproject.pet.entity;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import static com.msproject.pet.entity.QUserEntity.userEntity;
@RequiredArgsConstructor
@Repository
public class UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public boolean CheckExistsByUserId(String userId) {

        JPAQuery<UserEntity> query = queryFactory.selectFrom(userEntity)
                .where(userEntity.deleteYn.eq(false).and(userEntity.userId.eq(userId)));
        UserEntity user = query.fetchOne();

        //System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+user.getUserId());
        if(user != null){
            return true;
        }else{
            return false;
        }
    }

    public Boolean existsByEmail(String email) {

        JPAQuery<UserEntity> query = queryFactory.selectFrom(userEntity)
                .where(userEntity.deleteYn.eq(false).and(userEntity.email.eq(email)));

        UserEntity user = query.fetchOne();

        if(user != null){
            return true;
        }else{
            return false;
        }
    }


}
