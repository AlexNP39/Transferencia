package com.yape2.Transferencia2.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
public class ErrorDTO {
    private String code;
    private HttpStatus status;
    private String message;
}
