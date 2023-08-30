package com.ajou00.solution.service;

import com.ajou00.solution.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findRandomProducts();
    List<Product> findNonRandomProducts();

    List<Product> findAllProducts();

    void insertProduct(List<Product> productList);

}
