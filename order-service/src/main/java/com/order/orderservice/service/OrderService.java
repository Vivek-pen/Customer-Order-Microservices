package com.order.orderservice.service;

import com.order.orderservice.OrderServiceApplication;
import com.order.orderservice.entities.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order createOrder(Order newOrder);
}
