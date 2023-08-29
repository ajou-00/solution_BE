package com.ajou00.solution.controller;

import com.ajou00.solution.dto.OrderDto;
import com.ajou00.solution.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> addOrderList(@RequestBody List<OrderDto> orderDtoList){
        orderService.insertOrder(orderDtoList);
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
