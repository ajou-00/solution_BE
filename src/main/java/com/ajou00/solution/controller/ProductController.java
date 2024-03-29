package com.ajou00.solution.controller;

import com.ajou00.solution.domain.Product;
import com.ajou00.solution.dto.OrderDto;
import com.ajou00.solution.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> addProductList(@RequestBody List<Product> productList) {
        productService.insertProduct(productList);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAllProducts() {
        List<Product> productList = productService.findAllProducts();

        return ResponseEntity.ok().body(productList);
    }

    @GetMapping("/random")
    public ResponseEntity<?> findRandomProducts() {
        List<Product> randomProductList = productService.findRandomProducts();

        return ResponseEntity.ok().body(randomProductList);
    }

    @GetMapping("/non-random")
    public ResponseEntity<?> findNoneRandomProducts() {
        List<Product> NonrandomProductList = productService.findNonRandomProducts();

        return ResponseEntity.ok().body(NonrandomProductList);
    }


}
