package com.switchfully.selfeval.eurder.service.item;

import com.switchfully.selfeval.eurder.api.dto.item.CreateItemDTO;
import com.switchfully.selfeval.eurder.api.dto.item.ItemDTO;
import com.switchfully.selfeval.eurder.api.dto.item.ItemDetailsDTO;
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
                item.getPrice());
    }

    public List<ItemDTO> toDTO(List<Item> items) {
        return items.stream().map(this::toDTO).toList();
    }
    public ItemDetailsDTO toItemDetailsDTO(Item item) {
        return new ItemDetailsDTO(
                item.getItemId(),
                item.getItemName(),
                item.getDescription(),
                item.getPrice(),
                item.getAmountInStock());
    }

    public List<ItemDetailsDTO> toItemDetailsDTO(List<Item> items) {
        return items.stream().map(this::toItemDetailsDTO).toList();
    }
    public Item toDomain(CreateItemDTO createItemDTO) {
        return new Item(createItemDTO.getItemName(), createItemDTO.getDescription(), createItemDTO.getPrice(), createItemDTO.getAmountInStock());
    }
}
