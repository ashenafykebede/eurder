package com.switchfully.selfeval.eurder.service;

import com.switchfully.selfeval.eurder.api.dto.ItemGroupDTO;
import com.switchfully.selfeval.eurder.api.dto.CreateOrderDTO;
import com.switchfully.selfeval.eurder.domain.item.Item;
import com.switchfully.selfeval.eurder.domain.item.ItemAmountPair;
import com.switchfully.selfeval.eurder.domain.item.ItemGroup;
import com.switchfully.selfeval.eurder.domain.item.ItemRepository;
import com.switchfully.selfeval.eurder.domain.order.Order;
import com.switchfully.selfeval.eurder.domain.order.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public Order createOrder(CreateOrderDTO orderDTO) {
        //Get all itemDTOs
        List<ItemGroupDTO> itemGroupDTOs = orderDTO.getItemGroupDTOS();

        //Convert each itemGroupDTO to Item, amount pair

        List<ItemAmountPair> itemAmountPairs = itemGroupDTOs.stream()
                .map(itemGroupDTO -> new ItemAmountPair(
                        itemRepository.findItemById(itemGroupDTO.getItemId()),
                        itemGroupDTO.getAmountOrdered()))
                .toList();

        // Convert each itemAmountPair to itemGroup by calculating price and shipping date
        List<ItemGroup> itemGroups = itemAmountPairs.stream()
                .map(itemAmountPair -> new ItemGroup(
                        itemAmountPair.getItem(),
                        itemAmountPair.getAmountOrdered(),
                        calculatePricePerItemGroup(itemAmountPair.getItem(),itemAmountPair.getAmountOrdered()),
                        calculateShippingDate(itemAmountPair.getItem(),itemAmountPair.getAmountOrdered())))
                .toList();
        Order orderEnhanced = new Order(
                itemGroups,
                calculateTotalPricePerOrder(itemGroups),
                1
        );
        return orderRepository.createOrder(orderEnhanced);
    }

    private double calculateTotalPricePerOrder(List<ItemGroup> itemGroups) {
        return itemGroups.stream().map(ItemGroup::getPricePerItemGroup).reduce(0.0, Double::sum);
    }

    public List<Order> getAllMyOrders() {
        return orderRepository.getAllMyOrders();
    }

    private LocalDate calculateShippingDate(Item item, int amountOrdered) {
        if (item.getAmountInStock() >= amountOrdered) {
            return LocalDate.now().plusDays(1);
        }
        return LocalDate.now().plusDays(7);
    }

    private double calculatePricePerItemGroup(Item item, int amount) {
        return item.getPrice() * amount;

    }
}
