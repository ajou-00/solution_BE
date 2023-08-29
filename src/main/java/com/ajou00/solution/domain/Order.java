package com.ajou00.solution.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="productNum")
    private Product product;

    private int quantity;


}
