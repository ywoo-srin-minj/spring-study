package com.second.spring_study.dto.response.srin;

import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostListResponseDto {

    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private String userName;
    @NotNull
    private LocalDateTime createdAt;

}
