package com.switchfully.selfeval.eurder.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.switchfully.selfeval.eurder.api.dto.ItemGroupDTO;
import com.switchfully.selfeval.eurder.api.dto.OrderReportDTO;
import com.switchfully.selfeval.eurder.domain.order.Order;
import com.switchfully.selfeval.eurder.service.OrderService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Order createOrder(@RequestBody List<ItemGroupDTO> itemGroupDTOS) {
        return orderService.createOrder(itemGroupDTOS);

    }
    @GetMapping(path="reorder/{orderId}", produces = "application/json")
    public Order reOrder(@PathVariable String orderId) {
        return orderService.reOrder(orderId);

    }

    @GetMapping
    public OrderReportDTO getAllMyOrders() {
        return orderService.getAllMyOrders();
    }
}
