package com.shop.management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleElementNotFoundException(ElementNotFoundException e) {
        return createResponseEntity(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ElementAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleElementAlreadyExistsException(ElementAlreadyExistsException e) {
        return createResponseEntity(e, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e) {
        return createResponseEntity(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAnyException(Exception e) {
        return createResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> createResponseEntity(Exception e, HttpStatus status) {
        return ResponseEntity
                .status(status)
                .body(
                        ErrorResponse.builder()
                                .statusCode(status.value())
                                .error(status.name())
                                .exClassName(e.getClass().getName())
                                .message(e.getMessage())
                                .build()
                );
    }
}
