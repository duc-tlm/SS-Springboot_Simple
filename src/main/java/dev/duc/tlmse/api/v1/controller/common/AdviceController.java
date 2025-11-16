package dev.duc.tlmse.api.v1.controller.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class AdviceController {
    
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse handle(RuntimeException e) {
        log.error(e.getMessage(), e);
        return ErrorResponse.builder(e, HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong").build();
    }
    
}
