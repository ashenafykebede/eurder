package com.switchfully.selfeval.eurder.service;

import com.switchfully.selfeval.eurder.api.dto.ItemGroupDTO;
import com.switchfully.selfeval.eurder.api.dto.OrderReportDTO;
import com.switchfully.selfeval.eurder.domain.item.Item;
import com.switchfully.selfeval.eurder.domain.item.ItemAmountPair;
import com.switchfully.selfeval.eurder.domain.item.ItemGroup;
import com.switchfully.selfeval.eurder.domain.item.ItemRepository;
import com.switchfully.selfeval.eurder.domain.order.Order;
import com.switchfully.selfeval.eurder.domain.order.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }
    public Order createOrder(List<ItemGroupDTO> itemGroupDTOs) {

        List<ItemAmountPair> itemAmountPairs = convertToItemAmountPairs(itemGroupDTOs);

        List<ItemGroup> itemGroups = convertToItemGroups(itemAmountPairs);
        Order order = new Order(itemGroups, calculateTotalPricePerOrder(itemGroups), 1);
        return orderRepository.createOrder(order);
    }
    public Order getOrderById(String orderId) {
        return orderRepository.getOrderById(orderId);
    }

    public Order reOrder(String orderId) {
        Order reOreder = orderRepository.getOrderById(orderId);
        List<ItemGroupDTO> itemGroupDTOs = reOreder.getItemGroups()
                .stream()
                .map(itemGroup -> new ItemGroupDTO(
                        itemGroup.getItem().getItemId(),
                        itemGroup.getAmountOrdered()))
                .toList();

        return createOrder(itemGroupDTOs);
    }

    public OrderReportDTO getAllMyOrders() {
        List<Order> orders = orderRepository.getAllMyOrders();
        double totalPrice = calculateTotalPriceForAllMyOrders(orders);
        return new OrderReportDTO(orders, totalPrice);
    }

    private double calculateTotalPriceForAllMyOrders(List<Order> orders) {
        return orders.stream()
                .map(Order::getTotalPricePerOrder)
                .reduce(0.0, Double::sum);
    }


    private List<ItemGroup> convertToItemGroups(List<ItemAmountPair> itemAmountPairs) {
        return itemAmountPairs.stream()
                .map(itemAmountPair -> new ItemGroup(
                        itemAmountPair.getItem(),
                        itemAmountPair.getAmountOrdered(),
                        calculatePricePerItemGroup(itemAmountPair.getItem(), itemAmountPair.getAmountOrdered()),
                        calculateShippingDate(itemAmountPair.getItem(), itemAmountPair.getAmountOrdered())))
                .toList();
    }

    private List<ItemAmountPair> convertToItemAmountPairs(List<ItemGroupDTO> itemGroupDTOs) {
        return itemGroupDTOs.stream()
                .map(itemGroupDTO -> new ItemAmountPair(
                        new Item(itemRepository.findItemById(itemGroupDTO.getItemId())),
                        itemGroupDTO.getAmountOrdered()))
                .toList();
    }

    private double calculateTotalPricePerOrder(List<ItemGroup> itemGroups) {
        return itemGroups.stream().map(ItemGroup::getPricePerItemGroup).reduce(0.0, Double::sum);
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
