package com.second.spring_study.controller.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.second.spring_study.dto.request.minj.PostRequestDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class PostMinjControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void 게시글_추가_200() throws Exception {
        PostRequestDto postRequestDto = new PostRequestDto("post controller test", "게시글 추가 테스트");
        mockMvc.perform(post("/posts-minj/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postRequestDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 게시글_추가_404() throws Exception {
        PostRequestDto postRequestDto = new PostRequestDto("post controller test", "게시글 추가 테스트");
        mockMvc.perform(post("/posts-minj/3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postRequestDto)))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void 게시글_전체_조회_200() throws Exception {
        mockMvc.perform(get("/posts-minj"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 게시글_전체_조회_회원_필터_200() throws Exception {
        mockMvc.perform(get("/posts-minj?userpk=1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 게시글_상세_조회_200() throws Exception {
        mockMvc.perform(post("/posts-minj/details/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 게시글_상세_조회_404() throws Exception {
        mockMvc.perform(post("/posts-minj/details/3"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void 게시글_수정_200() throws Exception {
        PostRequestDto postRequestDto = new PostRequestDto("1. title", "content 수정");

        mockMvc.perform(put("/posts-minj/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postRequestDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 게시글_수정_404() throws Exception {
        PostRequestDto postRequestDto = new PostRequestDto("1. title", "content 수정");

        mockMvc.perform(put("/posts-minj/3")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postRequestDto)))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void 게시글_삭제_200() throws Exception {
        mockMvc.perform(delete("/posts-minj/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 게시글_삭제_404() throws Exception {
        mockMvc.perform(delete("/posts-minj/3"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }
}