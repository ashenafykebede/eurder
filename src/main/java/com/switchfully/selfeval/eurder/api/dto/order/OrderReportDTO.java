package com.switchfully.selfeval.eurder.api.dto.order;

import java.util.List;

public class OrderReportDTO {
    private final List<OrderDTO> orders;
    private final double TotalPrice;

    public OrderReportDTO(List<OrderDTO> ordersDTOs, double totalPrice) {
        this.orders = ordersDTOs;
        TotalPrice = totalPrice;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }
}
