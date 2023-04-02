package com.switchfully.selfeval.eurder.api.dto.item;

import com.switchfully.selfeval.eurder.domain.item.Item;

public class CreateItemDTO {
    private final String itemName;
    private final String description;
    private final double price;
    private final int amountInStock;

    public CreateItemDTO(String itemName, String description, double price, int amountInStock) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
    }

    public CreateItemDTO(Item item) {
        this.itemName = item.getItemName();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.amountInStock = item.getAmountInStock();

    }
    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getAmountInStock() {
        return amountInStock;
    }
}
