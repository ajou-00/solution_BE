package com.ajou00.solution.service;

import com.ajou00.solution.domain.Order;
import com.ajou00.solution.dto.OrderByDateDto;
import com.ajou00.solution.dto.OrderDto;

import java.util.List;

public interface OrderService {
    void insertOrder(List<OrderDto> orderDto);
    List<Order> findAll();

    List<OrderByDateDto> findOrderByDate(List<Order> orderList);
}
