package com.order.orderservice.service.impl;

import com.order.orderservice.entities.Order;
import com.order.orderservice.repository.OrderRepository;
import com.order.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order createOrder(Order newOrder) {
        return orderRepository.save(newOrder);
    }
}
