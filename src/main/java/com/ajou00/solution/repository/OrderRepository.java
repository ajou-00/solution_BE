package com.ajou00.solution.repository;

import com.ajou00.solution.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByProductNum(Long productNum);
}
