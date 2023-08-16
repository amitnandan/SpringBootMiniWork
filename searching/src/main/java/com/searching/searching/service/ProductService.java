package com.searching.searching.service;

import com.searching.searching.entity.Product;

import java.util.List;


public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
