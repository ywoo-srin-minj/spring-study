package com.second.spring_study.controller.post;

import com.second.spring_study.dto.request.ywoo.PostRequestCreateDto;
import com.second.spring_study.service.post.PostYwooService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post-ywoo")
public class PostYwooController {
    private final PostYwooService postYwooService;

    @PostMapping("/{userpk}")
    public void createPost(@PathVariable long userpk, @RequestBody PostRequestCreateDto postRequestCreateDto){
        postYwooService.createPost(postRequestCreateDto,userpk);
    }
}