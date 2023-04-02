package com.switchfully.selfeval.eurder.domain.item.itemResupply;

import com.switchfully.selfeval.eurder.api.dto.item.ItemsOverviewDTO;

import java.util.Comparator;

public class UrgencyComparator implements Comparator<ItemsOverviewDTO> {
    @Override
    public int compare(ItemsOverviewDTO itemsOverviewDTO1, ItemsOverviewDTO itemsOverviewDTO2) {
        if (itemsOverviewDTO1.getIndicator().getUrgency() == itemsOverviewDTO2.getIndicator().getUrgency()) {
            return 0;
        }
        if (itemsOverviewDTO1.getIndicator().getUrgency() > itemsOverviewDTO2.getIndicator().getUrgency()) {
            return 1;
        }
        return -1;
    }
}
