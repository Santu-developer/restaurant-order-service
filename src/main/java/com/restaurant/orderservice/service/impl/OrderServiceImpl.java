package com.restaurant.orderservice.service.impl;

import com.restaurant.orderservice.client.MenuClient;
import com.restaurant.orderservice.client.RestaurantClient;
import com.restaurant.orderservice.dto.MenuResponse;
import com.restaurant.orderservice.dto.OrderRequest;
import com.restaurant.orderservice.dto.OrderResponse;
import com.restaurant.orderservice.dto.RestaurantResponse;
import com.restaurant.orderservice.mapper.OrderMapper;
import com.restaurant.orderservice.model.Order;
import com.restaurant.orderservice.repository.OrderRepository;
import com.restaurant.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * OrderServiceImpl
 *
 * Purpose:
 * Implements OrderService business logic.
 *
 * Responsibilities:
 * - Validate restaurant via Feign
 * - Validate menu item via Feign
 * - Calculate order price
 * - Persist order to database
 *
 * Architecture:
 * Controller → Service → Repository
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    private final RestaurantClient restaurantClient;
    private final MenuClient menuClient;

    /**
     * Create new order
     */
    @Override
    public OrderResponse createOrder(OrderRequest request) {

        log.info("Creating order for restaurantId={}, menuItemId={}",
                request.getRestaurantId(),
                request.getMenuItemId());

        // Validate restaurant
        RestaurantResponse restaurant =
                restaurantClient.getRestaurant(request.getRestaurantId());

        if (restaurant == null) {
            throw new RuntimeException("Restaurant not found");
        }

        // Validate menu
        MenuResponse menu =
                menuClient.getMenu(request.getMenuItemId());

        if (menu == null) {
            throw new RuntimeException("Menu item not found");
        }

        // Convert DTO → Entity
        Order order = orderMapper.toEntity(request);

        // Calculate price
        double totalPrice = menu.getPrice() * request.getQuantity();
        order.setTotalPrice(totalPrice);

        // Initial order status
        order.setStatus("CREATED");

        Order savedOrder = orderRepository.save(order);

        log.info("Order created successfully with id={}", savedOrder.getId());

        return orderMapper.toResponse(savedOrder);
    }

    /**
     * Get order by ID
     */
    @Override
    public OrderResponse getOrder(Long id) {

        log.info("Fetching order id={}", id);

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return orderMapper.toResponse(order);
    }

    /**
     * Get all orders
     */
    @Override
    public List<OrderResponse> getAllOrders() {

        log.info("Fetching all orders");

        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toResponse)
                .collect(Collectors.toList());
    }

    /**
     * Delete order
     */
    @Override
    public void deleteOrder(Long id) {

        log.info("Deleting order id={}", id);

        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found");
        }

        orderRepository.deleteById(id);

        log.info("Order deleted successfully");
    }
}