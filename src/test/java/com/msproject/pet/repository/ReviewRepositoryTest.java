package com.msproject.pet.repository;

import com.msproject.pet.entity.PetHospitalEntity;
import com.msproject.pet.entity.ReviewEntity;
import com.msproject.pet.entity.UserEntity;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ReviewRepositoryTest {

    @Autowired
    ReviewRepository reviewRepository;

    @DisplayName("리뷰 생성")
    @Test
    public void testInsert(){
        Long hospital = 2429L;
        Long user = 1L;

        PetHospitalEntity petHospitalEntity = PetHospitalEntity.builder()
                .hospitalId(hospital).build();

        UserEntity userEntity = UserEntity.builder()
                .idx(user).build();

        IntStream.rangeClosed(1,100).forEach(i ->{
            ReviewEntity reviewEntity = ReviewEntity.builder()
                    .petHospitalEntity(petHospitalEntity)
                    .userEntity(userEntity)
                    .content("test..." + i)
                    .score(3)
                    .deleteYn(false)
                    .build();
            reviewRepository.save(reviewEntity);
        });

//        ReviewEntity reviewEntity = ReviewEntity.builder()
//                .petHospitalEntity(c)
//                .userEntity(userEntity)
//                .content("test")
//                .score(3)
//                .deleteYn(false).build();


    }

    @Test
    public void testPetHospitalReviews(){
        Long pet = 2479L;

        Pageable pageable = PageRequest.of(0,10, Sort.by("reviewId").descending());

        Page<ReviewEntity> result = reviewRepository.listOfReview(pet,pageable);

        result.getContent().forEach(reviewEntity -> {
            log.info(reviewEntity.getReviewId());
        });
    }


}