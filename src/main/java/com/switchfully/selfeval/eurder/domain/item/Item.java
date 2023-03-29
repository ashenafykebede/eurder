package com.switchfully.selfeval.eurder.domain.item;

public class Item {
    private final int itemId;
    private final String itemName;
    private final String description;
    private final float price;
    private final int amountInStock;
    private static int idGenerator = 0;

    public Item(String itemName, String description, float price, int amountInStock) {
        this.itemId = ++idGenerator;
        this.itemName = validateName(itemName);
        this.description = description;
        this.price = validatePrice(price);
        this.amountInStock = validateAmount(amountInStock);
    }


    private String validateName(String itemName) {
        if (itemName == null || itemName.isEmpty()) {
            throw new IllegalArgumentException("Incorrect input");
        }
        return itemName;
    }

    private float validatePrice(float price) {
        if (price < 0) {
            throw new IllegalArgumentException("Incorrect input");
        }
        return price;
    }

    private int validateAmount(int amountInStock) {
        if (amountInStock < 0) {
            throw new IllegalArgumentException("Incorrect input");
        }
        return amountInStock;
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
