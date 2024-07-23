package com.shop.management.exceptions;

public class ElementAlreadyExistsException extends RuntimeException {
    private String message;

    public ElementAlreadyExistsException() {
        super();
    }

    public ElementAlreadyExistsException(String msg) {
        super(msg);
        this.message = msg;
    }
}
