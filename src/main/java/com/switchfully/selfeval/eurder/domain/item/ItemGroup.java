package com.switchfully.selfeval.eurder.domain.item;

import java.time.LocalDate;

public class ItemGroup {
    private final Item item;
    private final int amountOrdered;
    private final double pricePerItemGroup;
    private final LocalDate shippingDate;

    public ItemGroup(Item item, int amountOrdered, double pricePerItemGroup, LocalDate shippingDate) {
        this.item = item;
        this.amountOrdered = amountOrdered;
        this.pricePerItemGroup = pricePerItemGroup;
        this.shippingDate = shippingDate;
    }

    public Item getItem() {
        return item;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public double getPricePerItemGroup() {
        return pricePerItemGroup;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
}
