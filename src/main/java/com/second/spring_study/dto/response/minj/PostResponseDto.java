package com.second.spring_study.dto.response.minj;

import com.second.spring_study.entity.minj.postMinj.PostMinj;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private String title;
    private String content;
    private String userName;
    private LocalDateTime createdAt;

    public static PostResponseDto of(PostMinj postMinj){
        PostResponseDto postResponseDto = new PostResponseDto();
        postResponseDto.title = postMinj.getPostTitle();
        postResponseDto.content = postMinj.getPostContent();
        postResponseDto.userName = postMinj.getUserMinj().getUserName();
        postResponseDto.createdAt = postMinj.getCreatedAt();
        return postResponseDto;
    }
}
