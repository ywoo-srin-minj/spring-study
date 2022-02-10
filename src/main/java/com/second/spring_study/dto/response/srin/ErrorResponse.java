package com.second.spring_study.dto.response.srin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class ErrorResponse {
    private int errorCode;  //HttpsStatus
    private String errorMessage;
}
