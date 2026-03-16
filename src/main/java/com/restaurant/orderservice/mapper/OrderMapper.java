package com.restaurant.orderservice.mapper;

import com.restaurant.orderservice.dto.OrderRequest;
import com.restaurant.orderservice.dto.OrderResponse;
import com.restaurant.orderservice.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toEntity(OrderRequest request);

    OrderResponse toResponse(Order order);

}