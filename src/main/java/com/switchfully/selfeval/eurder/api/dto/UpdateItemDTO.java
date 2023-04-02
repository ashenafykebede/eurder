package com.switchfully.selfeval.eurder.api.dto;

import com.switchfully.selfeval.eurder.domain.item.Item;

public class UpdateItemDTO {
    private String itemName;
    private String description;
    private double price;
    private int amountInStock;
    private static int idGenerator = 0;

    public UpdateItemDTO(String itemName, String description, double price, int amountInStock) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
    }

    public UpdateItemDTO(Item item) {
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
