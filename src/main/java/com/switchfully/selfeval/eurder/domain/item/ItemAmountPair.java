package com.switchfully.selfeval.eurder.domain.item;

public class ItemAmountPair {
    private Item item;
    private int amountOrdered;

    public ItemAmountPair(Item item, int amountOrdered) {
        this.item = item;
        this.amountOrdered = amountOrdered;
    }

    public Item getItem() {
        return item;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }
}
