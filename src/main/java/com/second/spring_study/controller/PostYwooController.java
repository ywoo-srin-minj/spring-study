package com.second.spring_study.controller;

import com.second.spring_study.dto.request.ywoo.PostRequestDto;
import com.second.spring_study.service.PostYwooService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post-ywoo")
public class PostYwooController {
    private final PostYwooService postYwooService;

    @PostMapping("/{userpk}")
    public void createBoards(@PathVariable long userpk, @RequestBody PostRequestDto postRequestDto){
        postYwooService.createBoards(postRequestDto,userpk);
    }
}
