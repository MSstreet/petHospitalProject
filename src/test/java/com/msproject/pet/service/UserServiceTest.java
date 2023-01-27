package com.msproject.pet.service;

import com.msproject.pet.entity.UserEntity;
import com.msproject.pet.entity.UserRepository;
import com.msproject.pet.web.dtos.UserDto;
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
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @DisplayName("1. 유저 생성 테스트")
    @Test
    void test_1() throws Exception{

        UserDto user1 = UserDto.builder()
                .userId("aaa_test")
                .userPw("bbbbbb11111")
                .userName("ccc")
                .build();

        UserEntity savedUser = userService.saveUser(user1);

        assertThat(user1.getUserId()).isEqualTo(savedUser.getUserId());

    }

}