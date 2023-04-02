package com.switchfully.selfeval.eurder.domain.item.itemGroup;

public class ItemGroupAddressPair {
    private final int userId;
    private final ItemGroup itemGroup;

    public ItemGroupAddressPair(int userId, ItemGroup itemGroup) {
        this.userId = userId;
        this.itemGroup = itemGroup;
    }

    public int getUserId() {
        return userId;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }
}
