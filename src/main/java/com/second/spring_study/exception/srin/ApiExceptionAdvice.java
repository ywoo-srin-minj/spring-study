package com.second.spring_study.exception.srin;

import com.second.spring_study.dto.response.srin.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
//@Slf4j //log를 작성할 수 있게 해주는 어노테이션(exception 반환에 방해가 됨)
@RestControllerAdvice
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
    public ResponseEntity<ErrorResponse> exceptionHandler(final MethodArgumentNotValidException e) {
        //log.error(e.getCause().getMessage());
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<ErrorResponse> exceptionHandler(final NullPointerException e) {
        //log.error(e.getCause().getMessage());
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

}
