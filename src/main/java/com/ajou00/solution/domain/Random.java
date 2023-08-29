package com.ajou00.solution.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Random {

    @Id
    @GeneratedValue
    private Long id;

    //당첨된 주문
    private Long orderId;

    //당첨된 사람
    private String userName;
}
