package com.cotivitiapp.productAPI.service;

import com.cotivitiapp.productAPI.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    List<Product> getAllProduct();
    Product getProductById(Long productId);
    void deleteProduct(Long productId);
    List<Product> findProductByCategoryId(Long categoryId);

//    List<Product> getProductByCategoryId(Long categoryId);
}
