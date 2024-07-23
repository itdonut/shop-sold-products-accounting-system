package com.shop.management.responses;

import lombok.Getter;

// Prefix F means formatted
// Prefix R means regular
@Getter
public enum ErrorResponseMessages {
    F_PRODUCT_NOT_FOUND_BY_ID("Product with id=%d hasn't been found"),
    F_PRODUCT_WITH_TITLE_ALREADY_EXISTS("Product with title=%s already exists"),
    R_PRODUCTS_NOT_FOUND("Products haven't been found"),
    R_ERROR_IN_REQUEST("There is an error in the request");

    private final String message;

    private ErrorResponseMessages(String message) { // this mustn't be called
        this.message = message;
    }
}
