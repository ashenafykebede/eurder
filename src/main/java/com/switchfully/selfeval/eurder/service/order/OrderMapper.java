package com.switchfully.selfeval.eurder.service.order;

import com.switchfully.selfeval.eurder.api.dto.order.OrderDTO;
import com.switchfully.selfeval.eurder.domain.order.Order;
import com.switchfully.selfeval.eurder.service.item.ItemGroupMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {
    private final ItemGroupMapper itemGroupMapper;

    public OrderMapper(ItemGroupMapper itemGroupMapper) {
        this.itemGroupMapper = itemGroupMapper;
    }

    public OrderDTO toDTO(Order order){
        return new OrderDTO(
                order.getOrderNumber(),
                itemGroupMapper.toDTO(order.getItemGroups()),
                order.getTotalPricePerOrder()
        );
    }
    public List<OrderDTO> toDTO(List<Order> orders){
        return orders.stream().map(this::toDTO).toList();
    }
}
