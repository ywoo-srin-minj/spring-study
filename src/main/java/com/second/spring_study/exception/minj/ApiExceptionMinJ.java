package com.second.spring_study.exception.minj;

import lombok.Getter;

@Getter
public class ApiExceptionMinJ extends RuntimeException {
    private final ErrorCodeEnum errorCodeEnum;

    public ApiExceptionMinJ(ErrorCodeEnum e){
        super(e.getMessage());
        this.errorCodeEnum = e;
    }
}
