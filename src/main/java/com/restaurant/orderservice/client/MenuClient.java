package com.restaurant.orderservice.client;


import com.restaurant.orderservice.dto.MenuResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "restaurant-menu-service")
public interface MenuClient {

    @GetMapping("/menus/{id}")
    MenuResponse getMenu(@PathVariable Long id);

}