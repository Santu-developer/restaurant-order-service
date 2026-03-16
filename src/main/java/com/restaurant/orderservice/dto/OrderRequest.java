package com.restaurant.orderservice.dto;

import lombok.Data;

@Data
public class OrderRequest {

    private Long restaurantId;

    private Long menuItemId;

    private Integer quantity;

}