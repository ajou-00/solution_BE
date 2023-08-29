package com.ajou00.solution.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class OrderDto {
    private Long productNum;
    private String userName;
    private Long quantity;
    private LocalDate timestamp;
}
