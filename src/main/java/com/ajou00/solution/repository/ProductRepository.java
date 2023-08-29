package com.ajou00.solution.repository;

import com.ajou00.solution.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByIsRandomTrue();
    List<Product> findByIsRandomFalse();

    Product findByProductNum(Long productNum);

}
