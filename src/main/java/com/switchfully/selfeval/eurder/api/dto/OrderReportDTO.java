package com.switchfully.selfeval.eurder.api.dto;

import com.switchfully.selfeval.eurder.domain.order.Order;

import java.util.List;

public class OrderReportDTO {
    private final List<Order> orders;
    private final double TotalPrice;

    public OrderReportDTO(List<Order> orders, double totalPrice) {
        this.orders = orders;
        TotalPrice = totalPrice;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }
}
