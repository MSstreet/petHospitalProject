package com.msproject.pet.service;

import com.msproject.pet.entity.ReviewEntity;
import com.msproject.pet.repository.ReviewRepository;
import com.msproject.pet.web.dtos.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

//    public ReviewEntity createReview(ReviewDto reviewDto){
//
//        ReviewEntity entity = ReviewEntity.builder()
//                .petHospitalEntity().build();
//
//        reviewRepository.save();
//    }
}
