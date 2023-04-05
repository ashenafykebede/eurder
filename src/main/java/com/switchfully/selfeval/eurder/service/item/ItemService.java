package com.switchfully.selfeval.eurder.service.item;

import com.switchfully.selfeval.eurder.api.dto.item.CreateItemDTO;
import com.switchfully.selfeval.eurder.api.dto.item.ItemDetailsDTO;
import com.switchfully.selfeval.eurder.api.dto.item.ItemsOverviewDTO;
import com.switchfully.selfeval.eurder.api.dto.item.UpdateItemDTO;
import com.switchfully.selfeval.eurder.domain.item.Item;
import com.switchfully.selfeval.eurder.domain.item.ItemRepository;
import com.switchfully.selfeval.eurder.domain.item.itemResupply.Indicator;
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
        Item updatedItem = itemRepository.getItemById(id).orElseThrow(ItemNotFoundException::new);

        updatedItem.setItemName(newItemData.getItemName());
        updatedItem.setDescription(newItemData.getDescription());
        updatedItem.setPrice(newItemData.getPrice());
        updatedItem.setAmountInStock(newItemData.getAmountInStock());

        return itemMapper.toItemDetailsDTO(itemRepository.save(updatedItem));
    }

    public List<ItemDetailsDTO> getAllItems() {
        return itemMapper.toItemDetailsDTO(itemRepository.getAllItems());
    }

    public ItemDetailsDTO getItemById(int itemID) {
        return itemMapper.toItemDetailsDTO(itemRepository.getItemById(itemID).orElseThrow(ItemNotFoundException::new));
    }

    public List<ItemsOverviewDTO> getItemsOverview() {
        List<ItemDetailsDTO> itemDetailsDTOS = getAllItems();
        return itemDetailsDTOS.stream().map(itemDetailsDTO -> new ItemsOverviewDTO(
                        itemDetailsDTO.itemId(),
                        itemDetailsDTO.itemName(),
                        calculateResuplyUrgency(itemDetailsDTO.amountInStock())
                ))
                .toList();
    }

    private Indicator calculateResuplyUrgency(int amountInStock) {
        if (amountInStock < 5) {
            return Indicator.STOCK_LOW;
        }
        if (amountInStock < 10) {
            return Indicator.STOCK_MEDIUM;
        }
        return Indicator.STOCK_HIGH;
    }


}
