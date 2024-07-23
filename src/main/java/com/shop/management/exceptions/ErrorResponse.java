package com.shop.management.exceptions;

import lombok.*;

@Builder
@Getter
@Setter
public class ErrorResponse {
    private int statusCode;
    private String error;
    private String exClassName;
    private String message;

    public ErrorResponse(int statusCode, String error, String exClassName, String message) {
        this.statusCode = statusCode;
        this.error = error;
        this.exClassName = exClassName;
        this.message = message;
    }
}
