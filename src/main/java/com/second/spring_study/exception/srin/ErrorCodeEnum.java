package com.second.spring_study.exception.srin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "User Not Found"),     //두 exception을 연결 할 때는 ,로 연결하기...(;말고)
    USER_ALREADY_EXIST(HttpStatus.CONFLICT.value(), "User Already Exist");

    private final int status;
    private final String message;
}
