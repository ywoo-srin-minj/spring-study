package com.second.spring_study.controller.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.second.spring_study.dto.request.srin.PostRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class PostSrinControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;

    @Autowired
    protected ObjectMapper objectMapper;

    @BeforeEach
    public void setUpMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void 게시글생성_200() throws Exception {
        String postTitle = "Title 입니다.";
        String postContent = "Content 입니다.";
        PostRequestDto postRequestDto = new PostRequestDto(postTitle, postContent);

        mockMvc.perform(post("/posts-srin/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postRequestDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 게시글생성_404() throws Exception {
        String postTitle = "존재할 수 없는 Title 입니다.";
        String postContent = "존재할 수 없는 Content 입니다.";
        PostRequestDto postRequestDto = new PostRequestDto(postTitle, postContent);

        mockMvc.perform(post("/posts-srin/-1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postRequestDto)))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void 회원전체게시글목록_200() throws Exception {
        mockMvc.perform(get("/posts-srin")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 회원게시글목록_200() throws Exception {
        mockMvc.perform(get("/posts-srin").param("userpk", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 게시글상세조회_200() throws Exception {
        mockMvc.perform(post("/posts-srin/details/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 게시글상세조회_404() throws Exception {
        mockMvc.perform(post("/posts-srin/details/-1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void 게시글수정_200() throws Exception {
        String postTitle = "수정된 Title입니다.";
        String postContent = "수정된 Content입니다.";
        PostRequestDto postRequestDto = new PostRequestDto(postTitle, postContent);

        mockMvc.perform(put("/posts-srin/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postRequestDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 게시글수정_404() throws Exception {
        String postTitle = "수정될 수 없는 Title입니다.";
        String postContent = "수정될 수 없는 Content입니다.";
        PostRequestDto postRequestDto = new PostRequestDto(postTitle, postContent);

        mockMvc.perform(put("/posts-srin/-1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(postRequestDto)))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    void 게시글삭제_200() throws Exception{
        mockMvc.perform(delete("/posts-srin/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void 게시글삭제_404() throws Exception{
        mockMvc.perform(delete("/posts-srin/-1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());
    }
}
