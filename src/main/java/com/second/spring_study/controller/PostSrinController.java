package com.second.spring_study.controller;

import com.second.spring_study.dto.request.srin.PostCreateRequestDto;
import com.second.spring_study.service.PostSrinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts-srin")
public class PostSrinController {
    private final PostSrinService postSrinService;

    @PostMapping("/{userpk}")
    public void createPost(@PathVariable Long userpk,  @RequestBody PostCreateRequestDto postCreateRequestDto){
        postSrinService.createPost(userpk, postCreateRequestDto);
    }

}
