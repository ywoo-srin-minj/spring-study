package com.second.spring_study.controller.post;

import com.second.spring_study.dto.request.ywoo.PostRequestCreateDto;
import com.second.spring_study.dto.response.ywoo.PostFindResponseDto;
import com.second.spring_study.service.post.PostYwooService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post-ywoo")
public class PostYwooController {
    private final PostYwooService postYwooService;

    @PostMapping("/{userpk}")
    public void createPost(@PathVariable long userpk, @RequestBody PostRequestCreateDto postRequestCreateDto){
        postYwooService.createPost(postRequestCreateDto,userpk);
    }

    @GetMapping()
    public List<PostFindResponseDto> findAllPost(@RequestParam(required = false) Long userpk){
        return postYwooService.findAllPosts(userpk);
    }

    @PostMapping("/details/{id}")
    public PostFindResponseDto findPost(@PathVariable long id){
        return postYwooService.findPost(id);
    }
}
