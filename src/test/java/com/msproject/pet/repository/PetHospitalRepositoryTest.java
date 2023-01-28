package com.msproject.pet.repository;

import com.msproject.pet.entity.PetHospitalEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PetHospitalRepositoryTest {

    @Autowired
    PetHospitalRepository petHospitalRepository;


    @DisplayName("업데이트 테스트")
    @Test
    public void testUpdate(){

        Long bno = 1L;

        Optional<PetHospitalEntity> petHospitalEntity = petHospitalRepository.findById(bno);

        PetHospitalEntity petHospitalEntity1 = petHospitalEntity.orElseThrow();

        petHospitalEntity1.change("광주시","도옹물","111","광자");

        petHospitalRepository.save(petHospitalEntity1);

    }
}
