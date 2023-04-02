package com.switchfully.selfeval.eurder.service.item;

import com.switchfully.selfeval.eurder.api.dto.ItemDTO;
import com.switchfully.selfeval.eurder.api.dto.UpdateItemDTO;
import com.switchfully.selfeval.eurder.domain.item.Item;
import com.switchfully.selfeval.eurder.domain.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDTO addItem(Item newItem) {
        return itemMapper.toDTO(itemRepository.save(newItem));
    }

    public ItemDTO updateItem(int id, UpdateItemDTO newItemData) {
        Item updatedItem = itemRepository.findItemById(id);
        updatedItem.setItemName(newItemData.getItemName());
        updatedItem.setDescription(newItemData.getDescription());
        updatedItem.setPrice(newItemData.getPrice());
        updatedItem.setAmountInStock(newItemData.getAmountInStock());
        return itemMapper.toDTO(itemRepository.save(updatedItem));
    }

    public List<ItemDTO> getAllItems() {
       return itemMapper.toDTO(itemRepository.getAllItems());
    }
}
