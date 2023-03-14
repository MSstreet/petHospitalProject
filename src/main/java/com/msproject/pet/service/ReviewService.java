package com.msproject.pet.service;

import com.msproject.pet.entity.PetHospitalEntity;
import com.msproject.pet.entity.ReviewEntity;
import com.msproject.pet.entity.UserEntity;
import com.msproject.pet.entity.UserRepository;
import com.msproject.pet.exception.InCorrectImageFileException;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private String path = "C:\\upload\\";

    private final ReviewRepository reviewRepository;

    private final ModelMapper modelMapper;

    private final PetHospitalRepository petHospitalRepository;

    private  final UserRepository userRepository;

    private final ReviewRepositoryCustom reviewRepositoryCustom;

    public double GetReviewAvg(Long id) {

        //float reviewAvg = reviewRepository.getReviewAvg(id);
        double reviewAvg = reviewRepositoryCustom.getReviewAvg(id);

        //reviewAvg = Math.round(reviewAvg * 100) / 100;
        DecimalFormat df = new DecimalFormat("#");
        reviewAvg = Integer.parseInt(df.format(reviewAvg));
        //int rounded = (int)Math.round(reviewAvg);
        return  reviewAvg;
    }

    public ReviewEntity ReviewCreate(ReviewDto reviewDto) throws Exception{

        Optional<PetHospitalEntity> petHospitalEntity = petHospitalRepository.findById(reviewDto.getPetHospitalNum());
        PetHospitalEntity pet = petHospitalEntity.orElseThrow();

        Optional<UserEntity> userEntity = userRepository.findById(reviewDto.getUserNum());
        UserEntity user = userEntity.orElseThrow();

//        String originalFilename = reviewDto.getFile().getOriginalFilename();
//        String uuid = UUID.randomUUID().toString();
//        String extension =  originalFilename.substring(originalFilename.lastIndexOf("."));
//        String savedName = uuid + extension;

        System.out.println(reviewDto.getEffectScore());
        System.out.println(reviewDto.getPriceScore());
        System.out.println(reviewDto.getKindnessScore());

        float avgScore = (float)(reviewDto.getEffectScore() + reviewDto.getPriceScore() + reviewDto.getKindnessScore()) / 3;

        System.out.println("평균값 확인" + avgScore);
        DecimalFormat df = new DecimalFormat("0.0");
        avgScore = Float.parseFloat(df.format(avgScore));

        ReviewEntity reviewEntity = ReviewEntity.builder()
                .petHospitalEntity(pet)
                .hospitalName(pet.getHospitalName())
                .userEntity(user)
                .content(reviewDto.getContent())
                .kindnessScore(reviewDto.getKindnessScore())
                .effectScore(reviewDto.getEffectScore())
                .priceScore(reviewDto.getPriceScore())
                //.score(reviewDto.getScore())
                .deleteYn(reviewDto.isDeleteYn())
//                .file(reviewDto.getFile())
                .tmpScore(avgScore)
                .fileName(reviewDto.getFileName())
                .originalFileName(reviewDto.getOriginalFileName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + reviewDto.getScore());
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + reviewEntity.getTmpScore());

        return reviewRepository.save(reviewEntity);
    }

    public ReviewEntity update(ReviewDto reviewDto) {

        ReviewEntity entity = reviewRepository.findById(reviewDto.getReviewId()).orElseThrow(()-> new RuntimeException("존재하지 않는 리뷰입니다."));
        float avgScore = (float)(reviewDto.getEffectScore() + reviewDto.getPriceScore() + reviewDto.getKindnessScore()) / 3;
        System.out.println("평균값 확인" + avgScore);
        DecimalFormat df = new DecimalFormat("0.0");
        avgScore = Float.parseFloat(df.format(avgScore));

        entity.changeReview(reviewDto.getContent(), avgScore,reviewDto.getFileName(),LocalDateTime.now(),reviewDto.getOriginalFileName(),reviewDto.getPriceScore(),reviewDto.getKindnessScore(),reviewDto.getEffectScore());



        return reviewRepository.save(entity);
    }

    public void delete(Long id) {
        ReviewEntity entity = reviewRepository.findById(id).orElseThrow(()-> new RuntimeException("존재하지 않는 리뷰입니다."));

        //deleteImage(entity.getFileName());
        //reviewRepository.delete(entity);
        entity.changeDeleteState();
        entity.isDeleteYn();

        reviewRepository.save(entity);
    }
    public void updateImage(Long id){
    }
    public void deleteImage(Long id){
        ReviewEntity entity = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 리뷰입니다."));
        String fileName = entity.getFileName();

        File file = new File(path + "\\" + fileName);

        if(file.exists()){
            file.delete();
        }
    }
    public ReviewDto getReview(Long id) {
        ReviewEntity entity = reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("존재하지 않는 리뷰입니다."));

        return ReviewDto.builder()
                .reviewId(entity.getReviewId())
                .petHospitalNum(entity.getPetHospitalEntity().getHospitalId())
                .petHospitalName(entity.getPetHospitalEntity().getHospitalName())
                .userNum(entity.getUserEntity().getIdx()) //수정 0207
                .content(entity.getContent())
                .score(entity.getScore())
                .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .updatedAt(entity.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                .fileName(entity.getFileName())
                .originalFileName(entity.getOriginalFileName())
                .build();
    }

    public Header<List<ReviewDto>> getReviewList(Pageable pageable, SearchCondition searchCondition, Long id) {

        List<ReviewDto> dtos = new ArrayList<>();
        Page<ReviewEntity> reviewEntities = reviewRepositoryCustom.findAllBySearchCondition(pageable, searchCondition, id);

        for (ReviewEntity entity : reviewEntities) {
            int rounded = (int)entity.getScore();

            ReviewDto dto = ReviewDto.builder()
                    .reviewId(entity.getReviewId())
                    .petHospitalNum(entity.getPetHospitalEntity().getHospitalId())
                    .userNum(entity.getUserEntity().getIdx()) // 수정 0207
                    .content(entity.getContent())
                    .score(rounded)
                    .priceScore(entity.getPriceScore())
                    .effectScore(entity.getEffectScore())
                    .kindnessScore(entity.getKindnessScore())
                    .userId(entity.getUserEntity().getUserId())
                    .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .updatedAt(entity.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
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
    public Header<List<ReviewDto>> getUserReviewList(Pageable pageable, SearchCondition searchCondition, Long id) {

        List<ReviewDto> dtos = new ArrayList<>();
        Page<ReviewEntity> reviewEntities = reviewRepositoryCustom.findAllByUserId(pageable, searchCondition, id);
        for (ReviewEntity entity : reviewEntities) {

            int rounded = (int)entity.getScore();
            ReviewDto dto = ReviewDto.builder()
                    .reviewId(entity.getReviewId())
                    .petHospitalNum(entity.getPetHospitalEntity().getHospitalId())
                    .userNum(entity.getUserEntity().getIdx()) // 수정 0207
                    .content(entity.getContent())
                    .score(rounded)
                    .tmpScore(entity.getTmpScore())
                    .priceScore(entity.getPriceScore())
                    .kindnessScore(entity.getKindnessScore())
                    .effectScore(entity.getEffectScore())
                    .userId(entity.getUserEntity().getUserId())
                    .hosName(entity.getPetHospitalEntity().getHospitalName())
                    .approveYn(entity.isApproveYn())
                    .createdAt(entity.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
                    .updatedAt(entity.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")))
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
