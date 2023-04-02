package com.switchfully.selfeval.eurder.service.order;

import com.switchfully.selfeval.eurder.api.dto.OrderDTO;
import com.switchfully.selfeval.eurder.domain.order.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {

    public OrderDTO toDTO(Order order){
        return new OrderDTO(
                order.getOrderNumber(),
                order.getItemGroups(),
                order.getTotalPricePerOrder()
        );
    }
    public List<OrderDTO> toDTO(List<Order> orders){
        return orders.stream().map(this::toDTO).toList();
    }
}
