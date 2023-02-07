package com.msproject.pet.service;



import com.msproject.pet.entity.PetHospitalEntity;
import com.msproject.pet.entity.ReviewEntity;
import com.msproject.pet.entity.UserEntity;
import com.msproject.pet.entity.UserRepository;
import com.msproject.pet.model.Header;
import com.msproject.pet.model.Pagination;
import com.msproject.pet.model.SearchCondition;
import com.msproject.pet.repository.PetHospitalRepository;
import com.msproject.pet.repository.ReviewRepository;

import com.msproject.pet.repository.ReviewRepositoryCustom;
import com.msproject.pet.web.dtos.ReviewDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final ModelMapper modelMapper;

    private final PetHospitalRepository petHospitalRepository;

    private  final UserRepository userRepository;

    private final ReviewRepositoryCustom reviewRepositoryCustom;


    public ReviewEntity ReviewCreate(ReviewDto reviewDto){

        ReviewEntity reviewEntity = modelMapper.map(reviewDto, ReviewEntity.class);

//        Optional<PetHospitalEntity> petHospitalEntity = petHospitalRepository.findById(reviewDto.getPetHospitalNum());
//
//        System.out.println("병원 번호 " + reviewDto.getPetHospitalNum());
//        System.out.println("유저번호 " + reviewDto.getUserNum());
//        PetHospitalEntity pet = pet.orElseThrow();
//
//        Optional<UserEntity> userEntity = userRepository.findById(reviewDto.getUserNum());
//
//
//        UserEntity user = userEntity.orElseThrow();
//
//        ReviewEntity reviewEntity = ReviewEntity.builder()
//                .petHospitalEntity(pet)
//                .userEntity(user)
//                .content(reviewDto.getContent())
//                .score(reviewDto.getScore())
//                .deleteYn(reviewDto.isDeleteYn())
//                .build();

        return reviewRepository.save(reviewEntity);
    }


    public ReviewEntity update(ReviewDto reviewDto) {

        ReviewEntity entity = reviewRepository.findById(reviewDto.getReviewId()).orElseThrow(()-> new RuntimeException("존재하지 않는 리뷰입니다."));

        entity.changeReview(reviewDto.getContent(), reviewDto.getScore());

        return reviewRepository.save(entity);
    }

    public void delete(Long id) {
        ReviewEntity entity = reviewRepository.findById(id).orElseThrow(()-> new RuntimeException("존재하지 않는 리뷰입니다."));

        reviewRepository.delete(entity);
    }


    public ReviewDto getReview(Long id) {
        ReviewEntity entity = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 리뷰입니다."));

        return ReviewDto.builder()
                .reviewId(entity.getReviewId())
                .petHospitalNum(entity.getPetHospitalEntity().getHospitalId())
                .userNum(entity.getUserIdx())
                .content(entity.getContent())
                .score(entity.getScore())
                .build();
    }

    public float getReviewAvg(Long id){

        List<ReviewEntity> reviewEntities = reviewRepository.findByPetHospitalEntity(id);
        float sum = 0;

        for(int i = 0; i < reviewEntities.size(); i ++){
                  sum = reviewEntities.get(i).getScore();
                  System.out.println(sum);
        }

        if(sum == 0){
            return 0;
        }else{
            return reviewRepository.getReviewAvg(id);
        }

    }


    public Header<List<ReviewDto>> getReviewList(Pageable pageable, SearchCondition searchCondition, Long id) {

        List<ReviewDto> dtos = new ArrayList<>();

        Page<ReviewEntity> reviewEntities = reviewRepositoryCustom.findAllBySearchCondition(pageable, searchCondition, id);

        for (ReviewEntity entity : reviewEntities) {

            ReviewDto dto = ReviewDto.builder()
                    .reviewId(entity.getReviewId())
                    .petHospitalNum(entity.getPetHospitalEntity().getHospitalId())
                    .userNum(entity.getUserIdx())
                    .content(entity.getContent())
                    .score(entity.getScore())
                    .build();

                dtos.add(dto);
            }

        Pagination pagination = new Pagination(
                (int) reviewEntities.getTotalElements()
                , pageable.getPageNumber() + 1
                , pageable.getPageSize()
                , 10
        );

        return Header.OK(dtos, pagination);
    }



}
