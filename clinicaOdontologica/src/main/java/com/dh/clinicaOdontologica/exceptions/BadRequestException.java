package com.dh.clinicaOdontologica.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;


public class BadRequestException extends ResponseStatusException{

    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
