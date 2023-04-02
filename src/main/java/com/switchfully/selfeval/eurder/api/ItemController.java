package com.switchfully.selfeval.eurder.api;

import com.switchfully.selfeval.eurder.api.dto.ItemDTO;
import com.switchfully.selfeval.eurder.domain.item.Item;
import com.switchfully.selfeval.eurder.domain.item.ItemRepository;
import com.switchfully.selfeval.eurder.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }
}
