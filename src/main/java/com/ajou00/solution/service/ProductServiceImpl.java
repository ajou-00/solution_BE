package com.ajou00.solution.service;

import com.ajou00.solution.domain.Product;
import com.ajou00.solution.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Override
    public List<Product> findRandomProducts() {
        return productRepository.findByIsRandomTrue();
    }

    @Override
    public List<Product> findNonRandomProducts() {
        return productRepository.findByIsRandomFalse();
    }
}
