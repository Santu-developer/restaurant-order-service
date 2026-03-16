package com.restaurant.orderservice.service;

import com.restaurant.orderservice.dto.OrderRequest;
import com.restaurant.orderservice.dto.OrderResponse;

import java.util.List;

/**
 * OrderService
 *
 * Purpose:
 * Defines the contract for Order related business operations.
 *
 * This interface is implemented by OrderServiceImpl.
 *
 * Responsibilities:
 * - Create order
 * - Fetch order by id
 * - Fetch all orders
 * - Delete order
 *
 * Architecture Role:
 * Controller → Service → Repository
 */

public interface OrderService {

    /**
     * Create new order
     */
    OrderResponse createOrder(OrderRequest request);

    /**
     * Get order by ID
     */
    OrderResponse getOrder(Long id);

    /**
     * Get all orders
     */
    List<OrderResponse> getAllOrders();

    /**
     * Delete order by ID
     */
    void deleteOrder(Long id);

}