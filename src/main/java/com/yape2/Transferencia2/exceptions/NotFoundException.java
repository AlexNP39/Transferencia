package com.yape2.Transferencia2.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class NotFoundException extends RuntimeException{
    private String code;
    private HttpStatus status;
    public NotFoundException(String code, HttpStatus status, String message){
        super(message);
        this.code = code;
        this.status = status;
    }
}
