package com.switchfully.selfeval.eurder.domain.item;

public class Item {
    private int itemId;
    private String itemName;
    private String description;
    private double price;
    private int amountInStock;
    private static int idGenerator = 0;

    public Item(String itemName, String description, double price, int amountInStock) {
        this.itemId = ++idGenerator;
        this.itemName = validateName(itemName);
        this.description = description;
        this.price = validatePrice(price);
        this.amountInStock = validateAmount(amountInStock);
    }

    public Item(Item item) {
        this.itemId = item.getItemId();
        this.itemName = item.getItemName();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.amountInStock = item.getAmountInStock();

    }


    private String validateName(String itemName) {
        if (itemName == null || itemName.isEmpty()) {
            throw new IllegalArgumentException("Incorrect input");
        }
        return itemName;
    }

    private double validatePrice(double price) {
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

    public double getPrice() {
        return price;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amountInStock=" + amountInStock +
                '}';
    }
}
