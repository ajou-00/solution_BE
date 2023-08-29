package com.ajou00.solution.repository;

import com.ajou00.solution.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByProductNum(Long productNum);
    List<Order> findAll();
}
