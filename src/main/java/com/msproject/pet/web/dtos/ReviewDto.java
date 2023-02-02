package com.msproject.pet.web.dtos;

import com.msproject.pet.entity.PetHospitalEntity;
import com.msproject.pet.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {

    private Long reviewId;

    private Long petHospitalNum;

    private Long userNum;

    private String content;

    private float score;

    private boolean deleteYn;
}
