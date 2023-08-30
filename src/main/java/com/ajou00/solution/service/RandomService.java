package com.ajou00.solution.service;

import com.ajou00.solution.domain.Order;
import com.ajou00.solution.domain.Product;
import com.ajou00.solution.domain.Random;
import com.ajou00.solution.dto.RandomResponseDto;

import java.util.List;

public interface RandomService {

    void lottery(List<Order> orderList, List<Product> randomProductList);

    List<RandomResponseDto> showUserResult(String userName);
}
