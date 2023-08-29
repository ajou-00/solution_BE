package com.ajou00.solution.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private Long productNum;

    private Long quantity;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timestamp;


}
