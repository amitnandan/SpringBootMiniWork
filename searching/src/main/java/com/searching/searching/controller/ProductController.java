package com.searching.searching.controller;

import com.searching.searching.entity.Product;
import com.searching.searching.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {


    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public Product createProduct( @RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProduct( @RequestParam ("query") String query ){

        List<Product> products = productService.searchProducts(query);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
