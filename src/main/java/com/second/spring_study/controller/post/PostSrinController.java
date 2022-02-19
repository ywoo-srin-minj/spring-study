package com.second.spring_study.controller.post;

import com.second.spring_study.dto.request.srin.PostRequestDto;
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
    public void createPost(@PathVariable Long userpk,  @RequestBody PostRequestDto postRequestDto){
        postSrinService.createPost(userpk, postRequestDto);
    }

    @GetMapping("")
    public List<PostInquiryResponseDto> findAllPosts(@RequestParam(value = "userpk", required = false) Long userpk){
        return postSrinService.findAllPosts(userpk);
    }

    @PostMapping("/details/{id}")
    public PostInquiryResponseDto findByIdPost(@PathVariable Long id){
        return postSrinService.findByIdPost(id);
    }


    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto){
        postSrinService.updatePost(id, postRequestDto);
    }

      
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id){
        postSrinService.deletePost(id);
    }
}
