package com.searching.searching.service.Impl;

import com.searching.searching.entity.Product;
import com.searching.searching.repository.ProductRepository;
import com.searching.searching.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductRepository productRepository;

    @Override
    public List<Product> searchProducts(String query) {


        List<Product> products = productRepository.searchProducts(query);
        return products;

    }

    @Override
    public Product createProduct(Product product) {
      return   productRepository.save(product);
    }
}
