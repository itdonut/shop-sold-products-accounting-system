package com.shop.management.services;

import com.shop.management.entities.Product;
import com.shop.management.exceptions.BadRequestException;
import com.shop.management.exceptions.ElementAlreadyExistsException;
import com.shop.management.exceptions.ElementNotFoundException;
import com.shop.management.repos.ProductRepository;
import com.shop.management.responses.ErrorResponseMessages;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {;
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(int id) {
        Optional<Product> product = productRepository.getProductById(id);
        if (product.isPresent())
            return product.get();
        else
            throw new ElementNotFoundException(ErrorResponseMessages.F_PRODUCT_NOT_FOUND_BY_ID.getMessage().formatted(id));
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty())
            throw new ElementNotFoundException(ErrorResponseMessages.R_PRODUCTS_NOT_FOUND.getMessage());
        else return products;
    }

    @Override
    public Product createProduct(Product product) {
        String title = product.getTitle();
        Optional<Product> existProduct = productRepository.getProductByTitle(title);

        if (existProduct.isPresent())
            throw new ElementAlreadyExistsException(
                    ErrorResponseMessages.F_PRODUCT_WITH_TITLE_ALREADY_EXISTS.getMessage().formatted(title)
            );
        else {
            product.setId(0); // to prevent updating in case object has initialized id
            return productRepository.save(product);
        }
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Optional<Product> existingProduct = productRepository.getProductById(id);
        if (existingProduct.isEmpty())
            throw new ElementNotFoundException(
                    ErrorResponseMessages.F_PRODUCT_NOT_FOUND_BY_ID.getMessage().formatted(id)
            );

        if (id == product.getId()) // path variable id and id field in entity must be the same to prevent creating new entity
            return productRepository.save(product);
        else
            throw new BadRequestException(
                    ErrorResponseMessages.R_ERROR_IN_REQUEST.getMessage()
            );
    }

    @Override
    public void deleteProductById(int id) {
        Optional<Product> product = productRepository.getProductById(id);
        if (product.isPresent())
            productRepository.deleteById(id);
        else
            throw new ElementNotFoundException(
                    ErrorResponseMessages.F_PRODUCT_NOT_FOUND_BY_ID.getMessage().formatted(id)
            );
    }
}
