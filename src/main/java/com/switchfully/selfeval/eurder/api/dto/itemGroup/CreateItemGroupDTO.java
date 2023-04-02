package com.switchfully.selfeval.eurder.api.dto.itemGroup;

public class CreateItemGroupDTO {
    private final int itemId;
    private final int amountOrdered;

    public CreateItemGroupDTO(int itemId, int amountOrdered) {
        this.itemId = itemId;
        this.amountOrdered = amountOrdered;
    }

    public int getItemId() {
        return itemId;
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    @Override
    public String toString() {
        return "ItemGroupDTO{" +
                "itemId=" + itemId +
                ", amountOrdered=" + amountOrdered +
                '}';
    }
}
