package com.restaurant.orderservice.dto;

import lombok.Data;

@Data
public class OrderResponse {

    private Long id;

    private Long restaurantId;

    private Long menuItemId;

    private Integer quantity;

    private Double totalPrice;

    private String status;

}