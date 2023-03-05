package com.msproject.pet.service;

import com.msproject.pet.entity.PetHospitalEntity;
import com.msproject.pet.repository.PetHospitalRepository;
import com.msproject.pet.web.dtos.PetHospitalDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PetHospitalServiceTest {

    @Autowired
    PetHospitalRepository petHospitalRepository;

    @Autowired
    PetHospitalService petHospitalService;

    @DisplayName("병원_생성")
    @Test
    void test_1(){

        PetHospitalDto petHospitalDto = PetHospitalDto.builder()
                .sigunName("부천")
                .hospitalName("동물병원")
                .hospitalNum("000111222")
                .hospitalAddr("부천시")
                .build();
                //.hospitalScore(2).build();

        PetHospitalEntity petHospitalEntity =  petHospitalService.create(petHospitalDto);

        assertThat(petHospitalDto.getHospitalName()).isEqualTo(petHospitalEntity.getHospitalName());

    }




}