package com.example.StudentManagement.advisor;

import com.example.StudentManagement.exception.NotFoundException;
import com.example.StudentManagement.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardResponse> handleInvalidArgument(ConstraintViolationException exception){


        List<String> errorMap = new ArrayList<>();

//        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        System.out.println(exception.getConstraintViolations());
        for (ConstraintViolation<?> error : exception.getConstraintViolations()) {//Recreate foreach again When you follow java 8 features
            errorMap.add(error.getMessage());
        }

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(500, "VALIDATION ERROR", errorMap ), HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, "ERROR COMING", e.getMessage() ), HttpStatus.NOT_FOUND);
    }
}