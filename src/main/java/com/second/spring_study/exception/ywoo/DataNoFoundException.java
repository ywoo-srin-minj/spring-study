package com.second.spring_study.exception.ywoo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataNoFoundException extends RuntimeException {

    private static final String message = "해당하는 id를 찾을 수 없음";

    public DataNoFoundException() {
        super(message);

    }
}
