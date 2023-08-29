package com.ajou00.solution.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrderByDateDto {

    private LocalDate date;
    private Long sales;
}
