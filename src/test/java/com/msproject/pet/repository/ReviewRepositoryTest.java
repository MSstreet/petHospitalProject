package com.msproject.pet.repository;

import com.msproject.pet.entity.PetHospitalEntity;
import com.msproject.pet.entity.ReviewEntity;
import com.msproject.pet.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ReviewRepositoryTest {

    @Autowired
    ReviewRepository reviewRepository;

    @DisplayName("리뷰 생성")
    @Test
    public void testInsert(){
        Long hospital = 636L;
        Long user = 5L;

        PetHospitalEntity petHospitalEntity = PetHospitalEntity.builder()
                .hospitalId(hospital).build();

        UserEntity userEntity = UserEntity.builder()
                .idx(user).build();

        ReviewEntity reviewEntity = ReviewEntity.builder()
                .petHospitalEntity(petHospitalEntity)
                .userEntity(userEntity)
                .content("test")
                .score(3)
                .deleteYn(false).build();

        reviewRepository.save(reviewEntity);
    }



}