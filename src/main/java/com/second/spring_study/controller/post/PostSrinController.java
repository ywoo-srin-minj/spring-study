package com.second.spring_study.controller.post;

import com.second.spring_study.dto.request.srin.PostCreateRequestDto;
import com.second.spring_study.dto.response.srin.PostListResponseDto;
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
    public List<PostListResponseDto> findAllPosts(@RequestParam("userpk") Long userpk){
        return postSrinService.findAllPosts(userpk);
    }
}
