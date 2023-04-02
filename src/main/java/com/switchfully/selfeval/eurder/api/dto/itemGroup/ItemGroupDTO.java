package com.switchfully.selfeval.eurder.api.dto.itemGroup;

import com.switchfully.selfeval.eurder.api.dto.item.ItemDTO;

import java.time.LocalDate;

public class ItemGroupDTO {

    private final ItemDTO item;
    private final int amountOrdered;
    private final double pricePerItemGroup;
    private final LocalDate shippingDate;

    public ItemGroupDTO(ItemDTO itemDTO, int amountOrdered, double pricePerItemGroup, LocalDate shippingDate) {
        this.item = itemDTO;
        this.amountOrdered = amountOrdered;
        this.pricePerItemGroup = pricePerItemGroup;
        this.shippingDate = shippingDate;
    }

    public ItemDTO getItem() {
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
