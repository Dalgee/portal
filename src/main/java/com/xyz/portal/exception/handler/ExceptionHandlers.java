package com.xyz.portal.exception.handler;

import com.xyz.portal.exception.AdminNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandlers {


    @ExceptionHandler(AdminNotFoundException.class)
    public ResponseEntity<ExceptionResponse> adminNotFoundExceptionHandler(AdminNotFoundException e) {
        return ResponseEntity.badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ExceptionResponse(404L, e.getMessage()));
    }
}
