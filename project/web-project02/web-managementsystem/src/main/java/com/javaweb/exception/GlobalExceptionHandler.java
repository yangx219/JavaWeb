package com.javaweb.exception;

import com.javaweb.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.error(e.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("error!!!", e);
        //get the error msg
        String message = e.getMessage();
        //get the position of words Duplicate entry
        int i = message.indexOf("Duplicate entry");
        //get the msg after Duplicate entry
        String errMsg = message.substring(i );
        //use blank space for separate
        String[] arr = errMsg.split(" ");
        return Result.error(arr[2]+" already exist");
    }
}
