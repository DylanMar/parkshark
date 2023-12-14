package com.switchfully.parkshark.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(IllegalArgumentException.class)
    protected void illegalArgumentException(IllegalArgumentException ex, HttpServletResponse response) throws IOException {
        response.sendError(BAD_REQUEST.value(), ex.getMessage());
    }

//    @ExceptionHandler(Exception.class)
//    protected void exception(Exception ex, HttpServletResponse response) throws Exception {
//        response.sendError(BAD_REQUEST.value(), ex.getMessage());
//    }
}