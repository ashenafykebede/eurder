package com.switchfully.selfeval.eurder.service.item;

import com.switchfully.selfeval.eurder.domain.item.Item;
import com.switchfully.selfeval.eurder.domain.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addItem(Item newItem) {
        return itemRepository.save(newItem);
    }

    public Item updateItem(int id, Item newItemDate) {
        Item updatedItem = itemRepository.findItemById(id);
        updatedItem.setItemName(newItemDate.getItemName());
        updatedItem.setDescription(newItemDate.getDescription());
        updatedItem.setPrice(newItemDate.getPrice());
        updatedItem.setAmountInStock(newItemDate.getAmountInStock());
        return itemRepository.save(updatedItem);
    }
}
