package com.switchfully.selfeval.eurder.api.dto;

import java.util.List;

public class CreateOrderDTO {
    private final List<ItemGroupDTO> items;

    public CreateOrderDTO(List<ItemGroupDTO> items) {
        this.items = items;
    }

    public List<ItemGroupDTO> getItemGroupDTOS() {
        return items;
    }

}
