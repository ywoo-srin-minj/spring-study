package com.second.spring_study.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.second.spring_study.dto.request.ywoo.UserRequestDto;
import com.second.spring_study.dto.request.ywoo.UserRequestUpdateDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
class UserYwooControllerTest {
  MockMvc mvc;

  @Autowired
  private WebApplicationContext context;

  @BeforeEach
  public void setUp(){
    mvc= MockMvcBuilders
            .webAppContextSetup(context)
            .addFilters(new CharacterEncodingFilter("UTF-8", true))
            .build();
  }

  @Test
  void 회원생성() throws Exception{

    UserRequestDto userRequestDto = new UserRequestDto("001","0000","ywoo");
    mvc.perform(post("/users-ywoo")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(userRequestDto)))
            .andExpect(status().isOk())
            .andDo(print());
  }
  @Test
  void 회원생성_에러_중복() throws Exception{
    UserRequestDto userRequestDto = new UserRequestDto("id001","0000","ywoo");
    mvc.perform(post("/users-ywoo")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(userRequestDto)))
            .andExpect(status().isConflict())
            .andDo(print());
  }

  @Test
  void 회원전체조회() throws Exception{
    mvc.perform(get("/users-ywoo")
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());
  }

  @Test
  void 회원상세조회() throws Exception{

    mvc.perform(post("/users-ywoo/1"))
            .andExpect(status().isOk())
            .andDo(print());
  }
  @Test
  void 회원상세조회_에러_유저없음() throws Exception{
    mvc.perform(post("/users-ywoo/111111"))
            .andExpect(status().isNotFound())
            .andDo(print());
  }

  @Test
  void 회원삭제() throws Exception{
    mvc.perform(delete("/users-ywoo/1"))
            .andExpect(status().isOk())
            .andDo(print());
  }
  @Test
  void 회원삭제_에러_유저없음() throws Exception{
    mvc.perform(delete("/users-ywoo/111111"))
            .andExpect(status().isNotFound())
            .andDo(print());
  }

  @Test
  void 회원정보수정() throws Exception{
    UserRequestUpdateDto userRequestUpdateDto = new UserRequestUpdateDto("papapapa","sssss");
    mvc.perform(put("/users-ywoo/2")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(userRequestUpdateDto)))
            .andExpect(status().isOk())
            .andDo(print());
  }

  @Test
  void 회원정보수정_에러_유저없음() throws Exception{
    UserRequestUpdateDto userRequestUpdateDto = new UserRequestUpdateDto("papapapa","sssss");
    mvc.perform(put("/users-ywoo/111111")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new ObjectMapper().writeValueAsString(userRequestUpdateDto)))
            .andExpect(status().is(404))
            .andDo(print());
  }
}