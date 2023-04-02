package com.switchfully.selfeval.eurder.api.dto;

import com.switchfully.selfeval.eurder.domain.item.ItemGroup;

import java.util.List;

public class OrderDTO {

    private final String orderNumber;
    private final List<ItemGroup> itemGroups;
    private final double totalPricePerOrder;

    public OrderDTO(String orderNumber, List<ItemGroup> itemGroups, double totalPricePerOrder) {
        this.orderNumber = orderNumber;
        this.itemGroups = itemGroups;
        this.totalPricePerOrder = totalPricePerOrder;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public double getTotalPricePerOrder() {
        return totalPricePerOrder;
    }
}
