package com.basicsite.yoxlama.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Map<String, Object>> handleCarNotFound(CarNotFoundException ex){
        Map<String,Object> body = new HashMap<>();
        body.put("Status" , HttpStatus.NOT_FOUND.value());
        body.put("message" , ex.getMessage());
        body.put("timestamp" , LocalDate.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

}
