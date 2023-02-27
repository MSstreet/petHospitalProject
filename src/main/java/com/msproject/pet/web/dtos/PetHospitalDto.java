package com.msproject.pet.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetHospitalDto {

    private Long hospitalId;

    private String sigunName;

    private String hospitalName;

    private String operState;

    private String hospitalNum;

    private String hospitalAddr; // 도로명 주소

    //private float hospitalScore;

    //private String operationYn;

    //private String hospitalZip;

    //private String hospitalStreetZip;

    //private String hospitalAddr; // 지번 주소

    //private String hospitalId;

    private BigDecimal hosLatitude ;

    private BigDecimal hosLongitude;
}
