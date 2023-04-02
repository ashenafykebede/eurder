package com.switchfully.selfeval.eurder.api.dto;

import com.switchfully.selfeval.eurder.domain.order.Order;

import java.util.List;

public class OrderReportDTO {
    private final List<OrderDTO> ordersDTOs;
    private final double TotalPrice;

    public OrderReportDTO(List<OrderDTO> ordersDTOs, double totalPrice) {
        this.ordersDTOs = ordersDTOs;
        TotalPrice = totalPrice;
    }

    public List<OrderDTO> getOrdersDTOs() {
        return ordersDTOs;
    }

    public double getTotalPrice() {
        return TotalPrice;
    }
}
