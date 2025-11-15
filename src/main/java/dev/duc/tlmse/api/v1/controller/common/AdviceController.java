package dev.duc.tlmse.api.v1.controller.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {
    
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse handle(RuntimeException e) {
        return ErrorResponse.builder(e, HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong").build();
    }
    
}
