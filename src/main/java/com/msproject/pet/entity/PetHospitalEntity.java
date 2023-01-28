package com.msproject.pet.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PetHospitalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public void change(String hospitalName, String hospitalNum, String hospitalAddr, String sigunName){
        this.hospitalName = hospitalName;
        this.hospitalNum = hospitalNum;
        this.hospitalAddr = hospitalAddr;
        this.sigunName = sigunName;
    }
}
