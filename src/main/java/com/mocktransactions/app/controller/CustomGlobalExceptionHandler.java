package com.mocktransactions.app.controller;

import com.mocktransactions.app.dto.CustomErrorResponse;
import com.mocktransactions.app.exception.UsuarioExceptionNotFound;
import com.mocktransactions.app.exception.ValidacaoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<CustomErrorResponse> customHandleBadRequest(Exception ex) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(BAD_REQUEST.value());

        return new ResponseEntity<>(errors, BAD_REQUEST);
    }

    @ExceptionHandler(UsuarioExceptionNotFound.class)
    public ResponseEntity<CustomErrorResponse> customUsuarioException(Exception ex) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError(ex.getMessage());
        errors.setStatus(NOT_FOUND.value());

        return new ResponseEntity<>(errors, NOT_FOUND);
    }

}
