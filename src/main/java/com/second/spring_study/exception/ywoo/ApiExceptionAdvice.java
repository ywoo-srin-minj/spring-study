package com.second.spring_study.exception.ywoo;

import com.second.spring_study.dto.response.ywoo.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionAdvice {
    //builder를 사용한 방법
   /* @ExceptionHandler({ApiException.class})
    public ResponseEntity<ErrorResponse> exceptionHandler(HttpServletRequest request, final ApiException e){
        return ResponseEntity
                .status(e.getErrorCodeEnum().getStatus())
                .body(ErrorResponse.builder()
                        .status(e.getErrorCodeEnum().getStatus())
                        .message(e.getErrorCodeEnum().getMessage())
                        .build());

    } */

    //생성자를 사용한 방법
    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ErrorResponse> exceptionHandler(HttpServletRequest request, final ApiException e){
        return new ResponseEntity<>(
                new ErrorResponse(
                e.getErrorCodeEnum().getStatus(),
                e.getErrorCodeEnum().getMessage()),
                HttpStatus.valueOf(e.getErrorCodeEnum().getStatus()));

    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> exceptionHandler(final MethodArgumentNotValidException e){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<ErrorResponse> exceptionHandler(final NullPointerException e){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);

    }

}
