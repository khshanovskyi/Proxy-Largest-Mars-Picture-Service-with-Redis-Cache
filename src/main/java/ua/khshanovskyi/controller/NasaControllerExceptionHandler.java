package ua.khshanovskyi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import feign.FeignException;

@ControllerAdvice
public class NasaControllerExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> handleFeignException(FeignException exception) {
        return ResponseEntity.badRequest()
          .body(String.format("<b>Something went wrong. Please check the exception message below</b> \n\n %s",
            exception.getMessage()));
    }
}
