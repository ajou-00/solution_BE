package com.ajou00.solution.controller;

import com.ajou00.solution.domain.Order;
import com.ajou00.solution.domain.Product;
import com.ajou00.solution.domain.Random;
import com.ajou00.solution.dto.RandomResponseDto;
import com.ajou00.solution.service.OrderService;
import com.ajou00.solution.service.ProductService;
import com.ajou00.solution.service.RandomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/random")
@RequiredArgsConstructor
public class RandomController {

    @Autowired
    private final RandomService randomService;

    @Autowired
    private final OrderService orderService;

    @Autowired
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> lottery(){
        List<Order> orderList = orderService.findAll();
        List<Product> randomProductList = productService.findRandomProducts();
        randomService.lottery(orderList, randomProductList);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findRandomByName(@PathVariable String name){
        List<RandomResponseDto> randomResponseDtoList = randomService.showUserResult(name);

        return ResponseEntity.ok().body(randomResponseDtoList);
    }

}
