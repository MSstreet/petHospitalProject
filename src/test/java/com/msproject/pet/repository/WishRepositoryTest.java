package com.msproject.pet.repository;

import com.msproject.pet.entity.PetHospitalEntity;
import com.msproject.pet.entity.ReviewEntity;
import com.msproject.pet.entity.UserEntity;
import com.msproject.pet.entity.WishEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class WishRepositoryTest {

    @Autowired
    private WishRepository wishRepository;

    @DisplayName("생성 테스트")
    @Test
    public void test1(){

        Long hospital = 2428L;
        Long user = 1L;

        PetHospitalEntity petHospitalEntity = PetHospitalEntity.builder()
                .hospitalId(hospital).build();

        UserEntity userEntity = UserEntity.builder()
                .idx(user).build();


        WishEntity wishEntity = WishEntity.builder()
                .petHospitalEntity(petHospitalEntity)
                .userEntity(userEntity)
                .build();
                //.wishState(true).build();




            wishRepository.save(wishEntity);


    }

}