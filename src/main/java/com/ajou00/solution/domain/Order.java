package com.ajou00.solution.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private Long productNum;

    private Long quantity;

    @Temporal(TemporalType.DATE)
    private LocalDate timestamp;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", productNum=" + productNum +
                ", quantity=" + quantity +
                ", timestamp=" + timestamp +
                '}';
    }
}
