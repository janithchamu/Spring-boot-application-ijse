package com.ijse.intro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.intro.entity.Order;
import com.ijse.intro.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    public OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
        
    }

    @Override
    public Order createOrder(Order order) {
      return orderRepository.save(order);
    }
    
}
