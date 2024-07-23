package com.shop.management.services;

import com.shop.management.entities.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(int id);
    public List<Product> getProducts();
    public Product createProduct(Product product);
    public Product updateProduct(int id, Product product);
    public void deleteProductById(int id);
}
