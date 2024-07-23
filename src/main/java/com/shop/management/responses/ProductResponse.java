package com.shop.management.responses;

import com.shop.management.entities.Product;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProductResponse {
    private List<Product> productList;
    private Product singleProduct;
    private String message;
}
