package com.ajou00.solution.repository;

import com.ajou00.solution.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByIsRandomTrue();
    List<Product> findByIsRandomFalse();

    Product findByProductNum(Long productNum);

}
