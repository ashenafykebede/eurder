package com.switchfully.selfeval.eurder.domain.order;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {
    private ConcurrentHashMap<UUID,Order> orderDatabase = new ConcurrentHashMap<>();
    public Order createOrder(Order order) {
        orderDatabase.put(order.getOrderNumber(),order);
        return orderDatabase.get(order.getOrderNumber());
    }

    public List<Order> getAllMyOrders() {
        return new ArrayList<>(orderDatabase.values());
    }
}
