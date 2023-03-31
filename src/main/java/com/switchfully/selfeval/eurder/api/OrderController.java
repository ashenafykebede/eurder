package com.switchfully.selfeval.eurder.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.switchfully.selfeval.eurder.api.dto.CreateOrderDTO;
import com.switchfully.selfeval.eurder.api.dto.ItemGroupDTO;
import com.switchfully.selfeval.eurder.domain.order.Order;
import com.switchfully.selfeval.eurder.service.OrderService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Order createOrder(@RequestBody List<ItemGroupDTO> itemGroupDTOS) {
        return orderService.createOrder(new CreateOrderDTO(itemGroupDTOS));

    }

    @GetMapping
    public List<Order> getAllMyOrders() {
        return orderService.getAllMyOrders();
    }
}
