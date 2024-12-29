package com.fastfood.burgerbox.service;

import com.fastfood.burgerbox.model.Order;
import com.fastfood.burgerbox.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public void postOrder(Order order){
        orderRepository.save(order);
    }

}
