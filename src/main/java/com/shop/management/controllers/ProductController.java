package com.shop.management.controllers;

import com.shop.management.entities.Product;
import com.shop.management.responses.ProductResponse;
import com.shop.management.responses.SuccessfulResponseMessages;
import com.shop.management.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ProductResponse> getProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ProductResponse.builder()
                                .productList(products)
                                .message(
                                        SuccessfulResponseMessages.R_PRODUCTS_FOUND.getMessage()
                                )
                                .build()
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable int id) {
        Product product = productService.getProductById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ProductResponse.builder()
                                .singleProduct(product)
                                .message(
                                        SuccessfulResponseMessages.F_PRODUCT_FOUND_BY_ID.getMessage().formatted(id)
                                )
                                .build()
                );
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ProductResponse.builder()
                                .singleProduct(createdProduct)
                                .message(
                                        SuccessfulResponseMessages.R_PRODUCT_CREATED.getMessage()
                                )
                                .build()
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ProductResponse.builder()
                                .singleProduct(updatedProduct)
                                .message(
                                        SuccessfulResponseMessages.F_PRODUCT_UPDATED.getMessage().formatted(id)
                                )
                                .build()
                );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductResponse> deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        ProductResponse.builder()
                                .message(
                                        SuccessfulResponseMessages.F_PRODUCT_DELETED.getMessage().formatted(id)
                                )
                                .build()
                );
    }
}
