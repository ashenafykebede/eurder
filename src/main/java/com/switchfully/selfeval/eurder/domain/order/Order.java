package com.switchfully.selfeval.eurder.domain.order;
import com.switchfully.selfeval.eurder.domain.item.ItemGroup;

import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID orderNumber;
    private final List<ItemGroup> itemGroups;
    private final double totalPricePerOrder;
    private final int userId;

    public Order(List<ItemGroup> itemGroups, double totalPricePerOrder, int userId) {
        this.orderNumber = UUID.randomUUID();
        this.itemGroups = itemGroups;
        this.totalPricePerOrder = totalPricePerOrder;
        this.userId = userId;
    }

    public UUID getOrderNumber() {
        return orderNumber;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public double getTotalPricePerOrder() {
        return totalPricePerOrder;
    }

    public int getUserId() {
        return userId;
    }
}
