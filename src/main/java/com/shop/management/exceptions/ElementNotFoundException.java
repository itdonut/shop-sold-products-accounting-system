package com.shop.management.exceptions;

public class ElementNotFoundException extends RuntimeException {
    private String message;

    public ElementNotFoundException() {
        super();
    }

    public ElementNotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }
}
