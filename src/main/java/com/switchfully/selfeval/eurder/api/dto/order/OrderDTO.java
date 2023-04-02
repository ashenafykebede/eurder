package com.switchfully.selfeval.eurder.api.dto.order;

import com.switchfully.selfeval.eurder.api.dto.itemGroup.ItemGroupDTO;

import java.util.List;

public class OrderDTO {

    private final String orderNumber;
    private final List<ItemGroupDTO> itemGroup;
    private final double totalPricePerOrder;

    public OrderDTO(String orderNumber, List<ItemGroupDTO> itemGroupDTOS, double totalPricePerOrder) {
        this.orderNumber = orderNumber;
        this.itemGroup = itemGroupDTOS;
        this.totalPricePerOrder = totalPricePerOrder;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public List<ItemGroupDTO> getItemGroup() {
        return itemGroup;
    }

    public double getTotalPricePerOrder() {
        return totalPricePerOrder;
    }
}
