package com.second.spring_study.controller.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.second.spring_study.dto.request.ywoo.PostRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Transactional
@SpringBootTest
public class PostYwooControllerTest {
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
    public void 게시글_생성() throws Exception{
        PostRequestDto postRequestDto = new PostRequestDto("testTtile","testContent");
        mvc.perform(post("/posts-ywoo/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(postRequestDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void 게시글_생성_NotFound_error() throws Exception{
        PostRequestDto postRequestDto = new PostRequestDto("testTtile","testContent");
        mvc.perform(post("/posts-ywoo/10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postRequestDto)))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    public void 게시글_전체조회() throws Exception{
        mvc.perform(get("/posts-ywoo")
                .param("userpk","1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void 게시글_상세조회() throws Exception{
        mvc.perform(post("/posts-ywoo/details/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void 게시글_상세조회_NotFoundError() throws Exception{
        mvc.perform(post("/posts-ywoo/details/10"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    public void 게시글_수정() throws Exception{
        PostRequestDto postRequestDto = new PostRequestDto("hello","goodbye");
        mvc.perform(put("/posts-ywoo/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(postRequestDto)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void 게시글_수정_NotFoundError() throws Exception{
        PostRequestDto postRequestDto = new PostRequestDto("hello","goodbye");
        mvc.perform(put("/posts-ywoo/10")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(postRequestDto)))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    public void 게시글_삭제() throws Exception{
        mvc.perform(delete("/posts-ywoo/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }
    @Test
    public void 게시글_삭제_NotFoundError() throws Exception{
        mvc.perform(delete("/posts-ywoo/10"))
                .andExpect(status().isNotFound())
                .andDo(print());
    }
}
