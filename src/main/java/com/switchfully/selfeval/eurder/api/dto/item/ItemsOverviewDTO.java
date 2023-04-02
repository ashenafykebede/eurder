package com.switchfully.selfeval.eurder.api.dto.item;

import com.switchfully.selfeval.eurder.domain.item.itemResupply.Indicator;

public class ItemsOverviewDTO {
    private final int itemId;
    private final String itemName;
    private final Indicator indicator;

    public ItemsOverviewDTO(int itemId, String itemName, Indicator indicator) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.indicator = indicator;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public Indicator getIndicator() {
        return indicator;
    }
}
