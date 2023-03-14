package com.msproject.pet.web.dtos;

import com.msproject.pet.entity.PetHospitalEntity;
import com.msproject.pet.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {

    private Long reviewId;

    private Long petHospitalNum;

    private String petHospitalName;

    private Long userNum;

    private String content;

    private String userId;

    private String hosName;


    private int priceScore;

    private int kindnessScore;

    private int effectScore;

    private float score;

    private float tmpScore;

    private boolean deleteYn;

    private String createdAt;

    private String updatedAt;

    private MultipartFile file;

    private String fileName;

    private boolean approveYn;

    private String originalFileName;

}
