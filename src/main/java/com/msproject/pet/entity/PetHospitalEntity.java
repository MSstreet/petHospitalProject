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
    private String hospitalName;
    private String sigunName;

    private String operState;
    private String hospitalNum;

    private String hospitalAddr; // 도로명 주소

    //private float petHospitalScore; //삭제해도 될 거 같은데

//    @Column(nullable = false)
//    private Integer wishScore;

    private BigDecimal hosLatitude ;

    private BigDecimal hosLongitude;

    public void change(String hospitalName, String hospitalNum, String hospitalAddr, String sigunName){
        this.hospitalName = hospitalName;
        this.hospitalNum = hospitalNum;
        this.hospitalAddr = hospitalAddr;
        this.sigunName = sigunName;
    }
}
