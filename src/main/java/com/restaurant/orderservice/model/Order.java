package com.restaurant.orderservice.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long restaurantId;

    private Long menuItemId;

    private Integer quantity;

    private Double totalPrice;

    private String status;

}