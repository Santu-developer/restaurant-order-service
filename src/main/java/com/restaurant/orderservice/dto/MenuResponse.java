package com.restaurant.orderservice.dto;

import lombok.Data;

@Data
public class MenuResponse {

    private Long id;
    private Long restaurantId;
    private String name;
    private String description;
    private Double price;
    private Boolean available;

}