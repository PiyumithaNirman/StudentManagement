package com.example.StudentManagement.advisor;

import com.example.StudentManagement.exception.NotFoundException;
import com.example.StudentManagement.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, "ERROR COMING", e.getMessage() + "Nirman"), HttpStatus.NOT_FOUND);
    }
}