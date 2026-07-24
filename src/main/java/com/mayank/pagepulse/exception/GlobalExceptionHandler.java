package com.mayank.pagepulse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SocketTimeoutException.class)
    public ResponseEntity<?> timeout(SocketTimeoutException ex){

        Map<String,Object> map = new HashMap<>();

        map.put("error","Website took too long to respond.");

        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(map);

    }

    @ExceptionHandler(MalformedURLException.class)
    public ResponseEntity<?> invalid(MalformedURLException ex){

        Map<String,Object> map = new HashMap<>();

        map.put("error","Invalid URL.");

        return ResponseEntity.badRequest().body(map);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegal(IllegalArgumentException ex){

        Map<String,Object> map = new HashMap<>();

        map.put("error",ex.getMessage());

        return ResponseEntity.badRequest().body(map);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> other(Exception ex){

        Map<String,Object> map = new HashMap<>();

        map.put("error","Unable to analyze website.");

        return ResponseEntity.status(500).body(map);

    }

}