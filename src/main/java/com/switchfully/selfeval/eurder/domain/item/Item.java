package com.switchfully.selfeval.eurder.domain.item;

public class Item {
    private int itemId;
    private String itemName;
    private String description;
    private float price;
    private int amountInStock;
    private static int idGenerator=0;

    public Item(String itemName, String description, float price, int amountInStock) {
        this.itemId = ++idGenerator;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.amountInStock = this.amountInStock;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public int getAmountInStock() {
        return amountInStock;
    }
}
