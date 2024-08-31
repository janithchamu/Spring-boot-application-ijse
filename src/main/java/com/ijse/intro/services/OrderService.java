package com.ijse.intro.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.intro.entity.Order;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order createOrder(Order order);
}
