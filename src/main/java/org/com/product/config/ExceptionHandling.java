package org.com.product.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidation(MethodArgumentNotValidException exception){
        ProblemDetail problemDetail=ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        List<String> errors=new ArrayList<>();
        List<FieldError> fieldErrors=exception.getFieldErrors();

        for (FieldError fieldError:fieldErrors){
            errors.add(fieldError.getDefaultMessage());
        }

        problemDetail.setProperty("errors",errors);
        return problemDetail;
    }
}
