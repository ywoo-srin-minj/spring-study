package com.second.spring_study.dto.request.srin;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostCreateRequestDto {
    @NotNull
    private String postTitle;

    @NotNull
    private String postContent;
}

