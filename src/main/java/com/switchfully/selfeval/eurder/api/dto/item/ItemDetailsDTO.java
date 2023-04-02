package com.switchfully.selfeval.eurder.api.dto.item;

public record ItemDetailsDTO(int itemId, String itemName, String description, double price, int amountInStock) {
}
