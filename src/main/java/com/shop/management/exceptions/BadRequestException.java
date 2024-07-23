package com.shop.management.exceptions;

public class BadRequestException extends RuntimeException {
    private String message;

    public BadRequestException() {
        super();
    }

    public BadRequestException(String msg) {
        super(msg);
        this.message = msg;
    }
}
