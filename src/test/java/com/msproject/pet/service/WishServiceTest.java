package com.msproject.pet.service;

import com.msproject.pet.entity.UserEntity;
import com.msproject.pet.web.dtos.WishDto;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@SpringBootTest
class WishServiceTest {

    @Autowired
    private WishService wishService;

    @DisplayName("생성 테스트")
    @Test
    public void test1(){

        WishDto wishDto = WishDto.builder()
                .petHospitalNum(2429L)
                .userNum(1L)
                //.wishState(false)
                .build();

        System.out.println("확인 : " + wishDto.getPetHospitalNum());

        wishService.wishCreate(wishDto);

       log.info( wishService.wishCreate(wishDto).getWishId());

    }

//    @DisplayName("생성 & 업데이트 테스트")
//    @Test
//    public void test2(){
//        WishDto wishDto = WishDto.builder()
//                .petHospitalNum(2429L)
//                .userNum(1L)
//                .wishState(true)
//                .build();
//    }

}