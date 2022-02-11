package com.second.spring_study.exception.ywoo;

import com.second.spring_study.dto.response.ywoo.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionAdviceYwoo {
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
    protected ResponseEntity<ErrorResponse> exceptionHandler(HttpServletRequest request, final ApiException e){
        return new ResponseEntity<>(
                new ErrorResponse(
                e.getErrorCodeEnum().getStatus(),
                e.getErrorCodeEnum().getMessage()),
                HttpStatus.valueOf(e.getErrorCodeEnum().getStatus()));

    }

    //null pointer와 같은 기타 에러들
    @ExceptionHandler({Exception.class})
    protected ResponseEntity<ErrorResponse> ExceptionHandler(final NullPointerException e){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<ErrorResponse> MethodArgumentNotValidExceptionHandler(final MethodArgumentNotValidException e){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    //SQL문이 안될때
    @ExceptionHandler({DataIntegrityViolationException.class})
    protected ResponseEntity<ErrorResponse> DataIntegrityViolationExceptionHandler(final DataIntegrityViolationException e){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.CONFLICT.value(),e.getMessage()), HttpStatus.CONFLICT);
    }

    //지원하지 않는 메서드
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    protected ResponseEntity<ErrorResponse> HttpRequestMethodNotSupportedExceptionHandler(final HttpRequestMethodNotSupportedException e){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.METHOD_NOT_ALLOWED.value(),e.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
