package com.zyl.sociality.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author zhuyanlin
 * @date 2019/8/23 11:34
 */
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(BizException.class)
    public ResponseEntity<ApiOut<String>> findEsException(BizException ex) {
        ApiOut<String> out = new ApiOut<>(ex.getCode(), ex.getMessage(),"");
        return new ResponseEntity<>(out, HttpStatus.OK);
    }
}
