package com.ajou00.solution.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long productNum;
    private String name;
    private Long price;
    private Long total;
    private Long orderCnt;
    private boolean isRandom;
}
