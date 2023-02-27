package com.msproject.pet.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WishDto {

    private Long wishId;

    private Long petHospitalNum;

    private Long userNum;

    //private boolean wishState;

    private int wishState1;

    private String hospitalName;

    private String hospitalNum;

    private String hospitalSigunName;

    private String hospitalAddr;

    private float hospitalScore;

    private String createdAt;

    private String updatedAt;


}
