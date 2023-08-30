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

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void insertProduct(List<Product> productList) {
        for(Product product : productList) {

            Product newProduct = Product.builder()
                    .productNum(product.getProductNum())
                    .name(product.getName())
                    .price(product.getPrice())
                    .total(product.getTotal())
                    .orderCnt(product.getOrderCnt())
                    .isRandom(product.isRandom())
                    .build();

            productRepository.save(newProduct);
        }
    }
}
