package com.switchfully.selfeval.eurder.service.item;

import com.switchfully.selfeval.eurder.api.dto.ItemDTO;
import com.switchfully.selfeval.eurder.domain.item.Item;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemMapper {
    public ItemDTO toDTO(Item item) {
        return new ItemDTO(
                item.getItemId(),
                item.getItemName(),
                item.getDescription(),
                item.getPrice(),
                item.getAmountInStock());
    }

    public List<ItemDTO> toDTO(List<Item> items) {
        return items.stream().map(this::toDTO).toList();
    }
}
