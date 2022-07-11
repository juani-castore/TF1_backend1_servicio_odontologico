package com.dh.clinicaOdontologica.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionsHandler {

    public static Logger logger = Logger.getLogger(GlobalExceptionsHandler.class);

    @ExceptionHandler
    public ResponseEntity<String> handleException(ResponseStatusException ex) {
        logger.error(ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }
}
