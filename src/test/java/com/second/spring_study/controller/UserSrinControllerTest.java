package com.second.spring_study.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.second.spring_study.dto.request.srin.UserRequestDto;
import com.second.spring_study.dto.request.srin.UserUpdateRequestDto;
import com.second.spring_study.entity.user_srin.UserSrin;
import com.second.spring_study.entity.user_srin.repository.UserSrinRepository;
import com.second.spring_study.service.UserSrinService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UserSrinControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;

    @Autowired
    protected ObjectMapper objectMapper;

    @BeforeEach
    public void setUpMockMvc() {
        mockMvc = MockMvcBuilders.
                webAppContextSetup(context).
                build();
    }

    @Test
    void 회원생성() throws Exception {
        //given
        String userId = "TEST";
        String userName = "테스트";
        String userPassword = "test1234";
        UserRequestDto userRequestDto = new UserRequestDto(userId, userPassword, userName);

        //when
        mockMvc.perform(post("/users-srin/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequestDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 회원중복생성() throws Exception {
        UserRequestDto userRequestDto = new UserRequestDto("HELLO", "1234", "HelloEveryone");
        UserRequestDto userRequestDto2 = new UserRequestDto("HELLO", "1234", "HelloEveryone");
        mockMvc.perform(post("/users-srin/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userRequestDto))
                        .content(new ObjectMapper().writeValueAsString(userRequestDto)))
                .andExpect(status().isConflict())
                .andDo(print());
    }

    @Test
    void 회원삭제() throws Exception {
        mockMvc.perform(delete("/users-srin/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(1)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 회원삭제_404() throws Exception {
        mockMvc.perform(delete("/users-srin/-1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());
        //404가 500이 error
    }

    @Test
    void 회원전체조회() throws Exception {
        mockMvc.perform(get("/users-srin")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 특정회원조회() throws Exception {
        mockMvc.perform(get("/users-srin/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 특정회원조회_404() throws Exception {
        mockMvc.perform(get("/users-srin/-1"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void 회원수정() throws Exception {
        UserUpdateRequestDto userUpdateRequestDto = new UserUpdateRequestDto("00000", "HI");
        mockMvc.perform(put("/users-srin/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userUpdateRequestDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 회원수정_404() throws Exception {
        UserUpdateRequestDto userUpdateRequestDto = new UserUpdateRequestDto("00000", "HI");
        mockMvc.perform(put("/users-srin/-1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userUpdateRequestDto)))
                .andExpect(status().isNotFound())
                .andDo(print());
    }
}
