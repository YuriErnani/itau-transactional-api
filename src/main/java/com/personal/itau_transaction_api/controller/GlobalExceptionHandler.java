package com.personal.itau_transaction_api.controller;

import com.personal.itau_transaction_api.infrastructure.exceptions.UnprocessableEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleUnprocessableEntity(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + exception.getMessage());
    }

    @ExceptionHandler(UnprocessableEntity.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<String> handleUnprocessableEntity(UnprocessableEntity unprocessableEntity) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Erro: " + unprocessableEntity.getMessage());
    }

}
