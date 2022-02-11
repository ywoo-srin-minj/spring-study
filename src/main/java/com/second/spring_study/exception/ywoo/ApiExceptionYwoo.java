package com.second.spring_study.exception.ywoo;

import lombok.Getter;

@Getter
public class ApiExceptionYwoo extends RuntimeException{
    private final ErrorCodeEnum errorCodeEnum;

    public ApiExceptionYwoo(ErrorCodeEnum e) {
        super(e.getMessage());
        this.errorCodeEnum=e;
    }
}
