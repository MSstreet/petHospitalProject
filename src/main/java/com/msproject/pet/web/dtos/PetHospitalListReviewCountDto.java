package com.msproject.pet.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetHospitalListReviewCountDto {

    private Long hospitalId;

    private String sigunName;

    private String hospitalName;

    private String operState;

    private String hospitalNum;

    private String hospitalAddr; // 도로명 주소

    private float hospitalScore;

    private Long reviewCount;
}
