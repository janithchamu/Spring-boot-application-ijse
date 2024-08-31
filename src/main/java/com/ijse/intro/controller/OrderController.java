package com.ijse.intro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ijse.intro.entity.Order;

import com.ijse.intro.services.OrderService;

@Service
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    

    @GetMapping("/orders")
    private ResponseEntity<List<Order>> getAllOrders(){
          return ResponseEntity.status(200).body(orderService.getAllOrders());
    }

    // @PostMapping("/orders")
    // private Order creatOrder(){
        
    // }
    

}
