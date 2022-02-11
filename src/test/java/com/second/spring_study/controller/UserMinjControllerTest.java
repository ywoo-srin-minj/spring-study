package com.second.spring_study.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.second.spring_study.dto.request.minj.UserRequestDto;
import com.second.spring_study.dto.request.srin.UserUpdateRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional()
@SpringBootTest
class UserMinjControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    /*
    * [200]
    * - 회원 생성
    * - 회원 조회
    * - 회원 상세 조회
    * - 회원 정보 수정
    * - 회원 삭제
    *
    * [409]
    * - 이미 존재하는 아이디일 경우
    *
    * [404]
    * - 존재하지 않는 아이디일 경우
     */

    @Test
    void 회원_생성_200() throws Exception {
        UserRequestDto userRequestDto = new UserRequestDto("m0_0m", "password", "minj");
        mockMvc.perform(post("/users-minj")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userRequestDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 회원_중복_409() throws Exception {
        UserRequestDto userRequestDto = new UserRequestDto("id001", "password", "minj");
        mockMvc.perform(post("/users-minj")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userRequestDto)))
                .andExpect(status().isConflict())
                .andDo(print());
    }

    @Test
    void 회원_목록_200() throws Exception {
        mockMvc.perform(get("/users-minj"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 회원_상세_조회_200() throws Exception {
        mockMvc.perform((post("/users-minj/1"))).andExpect(status().isOk()).andDo(print());
    }

    @Test
    void 회원_상세_조회_404() throws Exception {
        mockMvc.perform((post("/users-minj/1000"))).andExpect(status().isNotFound()).andDo(print());
    }

    @Test
    void 회원_정보_수정_200() throws Exception {
        UserUpdateRequestDto userUpdateRequestDto = new UserUpdateRequestDto("doremi", "minji");
        mockMvc.perform((post("/users-minj/1"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userUpdateRequestDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 회원_정보_수정_404() throws Exception {
        UserUpdateRequestDto userUpdateRequestDto = new UserUpdateRequestDto("doremi", "minji");
        mockMvc.perform((post("/users-minj/1000"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userUpdateRequestDto)))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void 회원_삭제_200() throws Exception {
        mockMvc.perform((delete("/users-minj/1"))).andExpect(status().isOk()).andDo(print());
    }

    @Test
    void 회원_삭제_404() throws Exception {
        mockMvc.perform((delete("/users-minj/1000"))).andExpect(status().isNotFound()).andDo(print());
    }
}