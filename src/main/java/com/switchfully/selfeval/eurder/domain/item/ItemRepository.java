package com.switchfully.selfeval.eurder.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {
    private ConcurrentHashMap<Integer, Item> itemsDatabase = new ConcurrentHashMap<>();

    public List<Item> getAllItems() {
        return new ArrayList<>(itemsDatabase.values());
    }

    public Item addItem(Item item) {
        itemsDatabase.put(item.getItemId(), item);
        return itemsDatabase.get(item.getItemId());
    }

    public Item findItemById(int id) {
        return itemsDatabase.get(id);
    }


}
