package com.restaurant.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestaurantOrderServiceApplication {

	public static void main(String[] args) {

        SpringApplication.run(RestaurantOrderServiceApplication.class, args);
        System.out.println("Jay Shree Ram - 7");
	}

}
