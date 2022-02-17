package com.second.spring_study.controller.post;

import com.second.spring_study.dto.request.srin.PostCreateRequestDto;
import com.second.spring_study.dto.response.srin.PostInquiryResponseDto;
import com.second.spring_study.service.post.PostSrinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/posts-srin")
public class PostSrinController {
    private final PostSrinService postSrinService;

    @PostMapping("/{userpk}")
    public void createPost(@PathVariable Long userpk,  @RequestBody PostCreateRequestDto postCreateRequestDto){
        postSrinService.createPost(userpk, postCreateRequestDto);
    }

    @GetMapping("")
    public List<PostInquiryResponseDto> findAllPosts(@RequestParam(value = "userpk", required = false) Long userpk){
        return postSrinService.findAllPosts(userpk);
    }

    @PostMapping("/details/{id}")
    public PostInquiryResponseDto findByIdPost(@PathVariable Long id){
        return postSrinService.findByIdPost(id);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postSrinService.deletePost(id);
    }
}
