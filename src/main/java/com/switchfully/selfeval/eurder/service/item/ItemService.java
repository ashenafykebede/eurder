package com.switchfully.selfeval.eurder.service.item;

import com.switchfully.selfeval.eurder.api.dto.item.CreateItemDTO;
import com.switchfully.selfeval.eurder.api.dto.item.ItemDetailsDTO;
import com.switchfully.selfeval.eurder.api.dto.item.UpdateItemDTO;
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

    public ItemDetailsDTO addItem(CreateItemDTO createItemDTO) {
        return itemMapper.toItemDetailsDTO(itemRepository.save(itemMapper.toDomain(createItemDTO)));
    }

    public ItemDetailsDTO updateItem(int id, UpdateItemDTO newItemData) {
        Item updatedItem = itemRepository.findItemById(id);
        updatedItem.setItemName(newItemData.getItemName());
        updatedItem.setDescription(newItemData.getDescription());
        updatedItem.setPrice(newItemData.getPrice());
        updatedItem.setAmountInStock(newItemData.getAmountInStock());
        return itemMapper.toItemDetailsDTO(itemRepository.save(updatedItem));
    }

    public List<ItemDetailsDTO> getAllItems() {
       return itemMapper.toItemDetailsDTO(itemRepository.getAllItems());
    }

    public ItemDetailsDTO getAnItem(int itemID) {
        return itemMapper.toItemDetailsDTO(itemRepository.findItemById(itemID));
    }
}
