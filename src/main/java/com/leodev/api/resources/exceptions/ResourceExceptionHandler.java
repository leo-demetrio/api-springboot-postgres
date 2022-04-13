package com.leodev.api.resources.exceptions;

import com.leodev.api.services.exceptions.DatabaseException;
import com.leodev.api.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
