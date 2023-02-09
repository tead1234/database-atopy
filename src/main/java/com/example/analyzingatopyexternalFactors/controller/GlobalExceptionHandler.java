package com.example.analyzingatopyexternalFactors.controller;

import com.example.analyzingatopyexternalFactors.dto.SymtomResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    private SymtomResponseDTO<String> handleArgumentException(Exception e) {
        return new SymtomResponseDTO<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
        // INTERNAL_SERVER_ERROR = 500 값임
    }
}
