package com.switchfully.selfeval.eurder.service.item;

import com.switchfully.selfeval.eurder.api.dto.itemGroup.ItemGroupDTO;
import com.switchfully.selfeval.eurder.domain.item.ItemGroup;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemGroupMapper {
    private final ItemMapper itemMapper;

    public ItemGroupMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public ItemGroupDTO toDTO(ItemGroup itemGroup){
        return new ItemGroupDTO(
                itemMapper.toDTO(itemGroup.getItem()),
                itemGroup.getAmountOrdered(),
                itemGroup.getPricePerItemGroup(),
                itemGroup.getShippingDate()
        );
    }
    public List<ItemGroupDTO> toDTO(List<ItemGroup> itemGroups){
        return itemGroups.stream().map(this::toDTO).toList();
    }
}
