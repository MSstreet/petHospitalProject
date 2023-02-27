package com.msproject.pet.service;

import com.msproject.pet.entity.ReviewEntity;
import com.msproject.pet.web.dtos.ReviewDto;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@SpringBootTest
class ReviewServiceTest {

    @Autowired
    private ReviewService reviewService;

//    @Test
//    public void testRegister(){
//
//        ReviewDto reviewDto = ReviewDto.builder()
//                .petHospitalNum(2429L)
//                .userNum(1L)
//                .content("dkdkdkd")
//                .score(3)
//                .deleteYn(false).build();
//
//        log.info(reviewService.ReviewCreate(reviewDto));
//    }

    @Test
    public void testUpdate(){

        ReviewDto reviewDto = ReviewDto.builder()
                .reviewId(2L)
                .content("변경")
                .score(2)
                .build();

        reviewService.update(reviewDto);
    }

    @Test
    public void testDelete(){

        reviewService.delete(2L);
    }

}