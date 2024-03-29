package com.ajou00.solution.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
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
