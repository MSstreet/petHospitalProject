package com.msproject.pet.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetHospitalDto {

    private Long hospitalId;

    private String sigunName;

    private String hospitalName;

    // private String operationYn;

    private String hospitalNum;

    //private String hospitalZip;

    //private String hospitalStreetZip;

    private String hospitalAddr; // 도로명 주소

    //private String hospitalAddr; // 지번 주소

    //private String hospitalId;

    //private BigDecimal latitude ;

    //private BigDecimal longitude;

    private float hospitalScore;
}
