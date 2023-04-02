package com.switchfully.selfeval.eurder.domain.order;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {
    private final ConcurrentHashMap<String, Order> orderDatabase = new ConcurrentHashMap<>();

    public Order createOrder(Order order) {
        orderDatabase.put(order.getOrderNumber(), order);
        return orderDatabase.get(order.getOrderNumber());
    }

    public List<Order> getAllMyOrders(int userId) {
        return new ArrayList<>(orderDatabase.values().stream().filter(order -> order.getUserId()==userId).toList());
    }

    public Order getOrderById(String orderId) {
        return orderDatabase.get(orderId);
    }
}
