package com.second.spring_study.exception.srin;

import com.second.spring_study.dto.response.srin.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
//@Slf4j //log를 작성할 수 있게 해주는 어노테이션(exception 반환에 방해가 됨)
public class ApiExceptionAdvice {
//    @ExceptionHandler({ApiException.class})
//    public ResponseEntity<ErrorResponse> exceptionHandler(HttpServletRequest request, final ApiException e){
//        //e.printStackTrace();
//        return ResponseEntity
//                .status(e.getError().getStatus())
//                .body(ErrorResponse.builder()
//                        .errorCode(e.getError().getStatus())
//                        .errorMessage(e.getError().getMessage())
//                        .build());
//    }

    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ErrorResponse> exceptionHandler(HttpServletRequest request, final ApiException e) {
        //log.error(e.getCause().getMessage());
        return new ResponseEntity<>(new ErrorResponse(e.getError().getStatus(), e.getError().getMessage()), HttpStatus.valueOf(e.getError().getStatus()));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> MethodArgumentNotValidExceptionHandler(final MethodArgumentNotValidException e) {
        //log.error(e.getCause().getMessage());
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> ExceptionHandler(final Exception e){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<ErrorResponse> NullPointerExceptionHandler(final NullPointerException e) {
        //log.error(e.getCause().getMessage());
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.CONFLICT.value(), e.getLocalizedMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<ErrorResponse> DataIntegrityViolationExceptionHandler(final DataIntegrityViolationException e) {
        //log.error(e.getCause().getMessage());
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorResponse> MethodArgumentTypeMismatchExceptionHandler(final MethodArgumentTypeMismatchException e) {
        //log.error(e.getCause().getMessage());
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<ErrorResponse> HttpRequestMethodNotSupportedExceptionHandler(final HttpRequestMethodNotSupportedException e) {
        //log.error(e.getCause().getMessage());
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.METHOD_NOT_ALLOWED.value(), e.getLocalizedMessage()), HttpStatus.METHOD_NOT_ALLOWED);
    }

}
