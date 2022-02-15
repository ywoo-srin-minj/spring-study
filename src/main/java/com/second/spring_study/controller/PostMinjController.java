package com.second.spring_study.controller;

import com.second.spring_study.dto.request.minj.CreatePostRequestDto;
import com.second.spring_study.service.PostMinjService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts-minj")
public class PostMinjController {
    private final PostMinjService boardMinjService;

    @PostMapping("/{userpk}")
    public void createPost(@PathVariable(name = "userpk") @Valid long userPk, @RequestBody @Valid CreatePostRequestDto createPostRequestDto) {
        boardMinjService.createPost(userPk, createPostRequestDto);
    }
}
