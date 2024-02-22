package com.yape2.Transferencia2.controller;

import com.yape2.Transferencia2.DTO.ErrorDTO;
import com.yape2.Transferencia2.exceptions.NotFoundException;
import com.yape2.Transferencia2.exceptions.RequestException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class ControllerAdvice {

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorDTO> requestExceptionHandler(RequestException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().code(ex.getCode()).status(ex.getStatus()).message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorDTO> notfoundExceptionHandler(NotFoundException ex){
        ErrorDTO errorDTO = ErrorDTO.builder().code(ex.getCode()).status(ex.getStatus()).message(ex.getMessage()).build();
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);

    }
}
