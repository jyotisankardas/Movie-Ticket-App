package com.enb.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidMovieIdException.class)
    public ResponseEntity<String> handleInvalidMovieIdException(InvalidMovieIdException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(InvalidTicketIdException.class)
    public ResponseEntity<String> handleInvalidTicketIdException(InvalidTicketIdException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

