package com.switchfully.selfeval.eurder.api;

import com.switchfully.selfeval.eurder.api.dto.ItemGroupDTO;
import com.switchfully.selfeval.eurder.api.dto.OrderDTO;
import com.switchfully.selfeval.eurder.api.dto.OrderReportDTO;
import com.switchfully.selfeval.eurder.domain.order.Order;
import com.switchfully.selfeval.eurder.service.order.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public OrderDTO createOrder(@RequestBody List<ItemGroupDTO> itemGroupDTOS) {
        return orderService.createOrder(itemGroupDTOS);

    }
    @GetMapping(path="reorder/{orderId}", produces = "application/json")
    public OrderDTO reOrder(@PathVariable String orderId) {
        return orderService.reOrder(orderId);

    }

    @GetMapping
    public OrderReportDTO getAllMyOrders() {
        int userId = 1; //TODO : get id from user authentication
        return orderService.getAllMyOrders(userId);
    }
}
