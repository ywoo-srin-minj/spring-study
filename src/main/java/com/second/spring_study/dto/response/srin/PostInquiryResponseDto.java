package com.second.spring_study.dto.response.srin;


import com.second.spring_study.entity.srin.post_srin.PostSrin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class PostInquiryResponseDto {
    @NotNull
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private String userName;

    @NotNull
    private LocalDateTime createdAt;

    public static PostInquiryResponseDto of(PostSrin postSrin) {
        return PostInquiryResponseDto.builder()
                .id(postSrin.getPostId())
                .title(postSrin.getPostTitle())
                .content(postSrin.getPostContent())
                .userName(postSrin.getUserSrin().getUserName())
                .createdAt(postSrin.getCreatedAt())
                .build();
    }
}
