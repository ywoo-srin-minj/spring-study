package com.second.spring_study.exception.srin;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiException extends RuntimeException{
    private final ErrorCodeEnum error;

    public ApiException(ErrorCodeEnum e){
        super(e.getMessage());
        this.error = e;
    }
}
