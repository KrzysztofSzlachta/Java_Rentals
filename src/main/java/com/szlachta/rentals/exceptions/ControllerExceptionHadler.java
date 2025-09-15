package com.szlachta.rentals.exceptions;

import com.szlachta.rentals.dto.BasicErrorResponse;
import com.szlachta.rentals.dto.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHadler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<ValidationErrorResponse>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex
    ) {
        List<ValidationErrorResponse> errors = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String field;

            if (error instanceof FieldError fieldError){
                field = error.getObjectName() + "." + fieldError.getField();
            }
            else {
                field = error.getObjectName();
            }

            String message = error.getDefaultMessage();
            errors.add(new ValidationErrorResponse(field, message));
        }
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<BasicErrorResponse> handleNotFoundException(
            NotFoundException ex
    ) {
        BasicErrorResponse error = new BasicErrorResponse();
        error.setMessage(ex.getMessage());
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.IM_USED)
    public ResponseEntity<BasicErrorResponse> handleInUseException(
            ConflictException ex
    ){
        BasicErrorResponse error = new BasicErrorResponse();
        error.setMessage(ex.getMessage());
        return ResponseEntity.status(409).body(error);
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BasicErrorResponse> handleBadRequestException(
            BadRequestException ex
    ){
        BasicErrorResponse error = new BasicErrorResponse();
        error.setMessage(ex.getMessage());
        return ResponseEntity.status(400).body(error);
    }
}
