package com.restaurant.orderservice.controller;

import com.restaurant.orderservice.dto.OrderRequest;
import com.restaurant.orderservice.dto.OrderResponse;
import com.restaurant.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public OrderResponse create(@RequestBody OrderRequest request) {
        return service.createOrder(request);
    }

    @GetMapping
    public List<OrderResponse> getAll() {
        return service.getAllOrders();
    }

   @GetMapping("{id}")
    public OrderResponse getById(@PathVariable Long id){
        return service.getOrder(id);
   }

}