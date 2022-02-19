package com.second.spring_study.dto.response.ywoo;

import com.second.spring_study.entity.ywoo.postYwoo.PostYwoo;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PostFindResponseDto {

    private long id;
    private String title;
    private String content;
    private String userName;
    private LocalDateTime createdAt;


    public static PostFindResponseDto of(PostYwoo postYwoo){
        PostFindResponseDto postFindResponseDto = new PostFindResponseDto();
        postFindResponseDto.id = postYwoo.getId();
        postFindResponseDto.title = postYwoo.getPostTitle();
        postFindResponseDto.content = postYwoo.getPostContent();
        postFindResponseDto.userName = postYwoo.getUserYwoo().getUserName();
        postFindResponseDto.createdAt = postYwoo.getCreatedAt();

        return postFindResponseDto;
    }
}
