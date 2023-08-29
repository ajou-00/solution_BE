package com.ajou00.solution.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@RequiredArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue
    private Long productNum;

    private int total;

    private boolean isRandom;

    @OneToMany(mappedBy = "product")
    private List<Order> orderList;
}
