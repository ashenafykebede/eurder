package com.switchfully.selfeval.eurder.domain.order;

import com.switchfully.selfeval.eurder.domain.item.ItemGroup;
import com.switchfully.selfeval.eurder.domain.item.ItemGroupAddressPair;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    private final ConcurrentHashMap<String, Order> orderDatabase = new ConcurrentHashMap<>();

    public Order createOrder(Order order) {
        orderDatabase.put(order.getOrderNumber(), order);
        return orderDatabase.get(order.getOrderNumber());
    }

    public List<Order> getAllMyOrders() {
        return new ArrayList<>(orderDatabase.values());
    }

    public Order getOrderById(String orderId) {
        return orderDatabase.get(orderId);
    }
}
