package com.shop.management.responses;

import lombok.Getter;

// Prefix F means formatted
// Prefix R means regular
@Getter
public enum SuccessfulResponseMessages {
    F_PRODUCT_DELETED("Product with id=%d has been deleted successfully"),
    F_PRODUCT_FOUND_BY_ID("Product with id=%d has been found successfully"),
    F_PRODUCT_UPDATED("Product with id=%d has been updated successfully"),
    R_PRODUCTS_FOUND("Products have been found successfully"),
    R_PRODUCT_CREATED("The product has been created successfully");


    private final String message;

    private SuccessfulResponseMessages(String message) { // this mustn't be called
        this.message = message;
    }
}
