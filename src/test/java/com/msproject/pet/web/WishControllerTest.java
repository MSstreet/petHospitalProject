package com.msproject.pet.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msproject.pet.web.dtos.WishDto;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class WishControllerTest {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    private MockMvc mockMvc;



    @DisplayName("1")
    @Test
    void test_1() throws Exception {

        String body = mapper.writeValueAsString(
                WishDto.builder()
                        .petHospitalNum(2429L)
                        .userNum(1L)
                        .wishState(false)
                        .build()
        );

        ResultActions result = mockMvc.perform(post("/wish")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        //System.out.println(mvcResult.getResponse().getContentAsString());
    }

}