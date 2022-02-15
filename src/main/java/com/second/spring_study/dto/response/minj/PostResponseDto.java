package com.second.spring_study.dto.response.minj;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private String title;
    private String content;
    private String userName;
    private LocalDateTime createdAt;
}
