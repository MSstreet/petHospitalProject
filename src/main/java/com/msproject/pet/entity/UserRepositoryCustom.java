package com.msproject.pet.entity;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

import static com.msproject.pet.entity.QUserEntity.userEntity;
@RequiredArgsConstructor
@Repository
public class UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final EntityManager em;
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

    public UserEntity findByUserId(String username) {

        JPAQuery<UserEntity> query = queryFactory.selectFrom(userEntity)
                .where(userEntity.deleteYn.eq(false).and(userEntity.userId.eq(username)));

        UserEntity user = query.fetchOne();

        if(user == null){
            new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

       return user;
    }

    @Transactional
    public void delete(Long Idx){

        em.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0 ;").executeUpdate();
       long count = queryFactory.delete(userEntity).where(userEntity.idx.eq(Idx)).execute();
        em.createNativeQuery("SET FOREIGN_KEY_CHECKS = 1 ;").executeUpdate();
    }
}
