package com.second.spring_study.exception.ywoo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND.value(),"User Not Found"),
    USER_ALREADY_EXIST(HttpStatus.CONFLICT.value(), "User Already Exist"),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "Post Not Found");
    private final int status;
    private final String message;

}
