package com.switchfully.selfeval.eurder.service.order;

import com.switchfully.selfeval.eurder.api.dto.itemGroup.CreateItemGroupDTO;
import com.switchfully.selfeval.eurder.api.dto.order.OrderDTO;
import com.switchfully.selfeval.eurder.api.dto.order.OrderReportDTO;
import com.switchfully.selfeval.eurder.domain.item.Item;
import com.switchfully.selfeval.eurder.domain.item.ItemAmountPair;
import com.switchfully.selfeval.eurder.domain.item.itemGroup.ItemGroup;
import com.switchfully.selfeval.eurder.domain.item.ItemRepository;
import com.switchfully.selfeval.eurder.domain.order.Order;
import com.switchfully.selfeval.eurder.domain.order.OrderRepository;
import com.switchfully.selfeval.eurder.service.item.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.orderMapper = orderMapper;
    }
    public OrderDTO createOrder(List<CreateItemGroupDTO> itemGroupDTOs) {

        List<ItemAmountPair> itemAmountPairs = convertToItemAmountPairs(itemGroupDTOs);

        updateAmountInStock(itemAmountPairs);

        List<ItemGroup> itemGroups = convertToItemGroups(itemAmountPairs);

        Order order = new Order(itemGroups, calculateTotalPricePerOrder(itemGroups), 1);
        return orderMapper.toDTO(orderRepository.createOrder(order));
    }

    private void updateAmountInStock(List<ItemAmountPair> itemAmountPairs) {
        itemAmountPairs.forEach(itemAmountPair -> {
           if (itemAmountPair.getItem().getAmountInStock()<=itemAmountPair.getAmountOrdered()){
               itemAmountPair.getItem().setAmountInStock(0);
           }else {
               itemAmountPair.getItem().setAmountInStock(itemAmountPair.getItem().getAmountInStock()-itemAmountPair.getAmountOrdered());
           }
            itemRepository.save(itemAmountPair.getItem());
        });
    }

    public Order getOrderById(String orderId) {
        return orderRepository.getOrderById(orderId);
    }

    public OrderDTO reOrder(String orderId) {
        Order reOreder = orderRepository.getOrderById(orderId);
        List<CreateItemGroupDTO> itemGroupDTOs = reOreder.getItemGroups()
                .stream()
                .map(itemGroup -> new CreateItemGroupDTO(
                        itemGroup.getItem().getItemId(),
                        itemGroup.getAmountOrdered()))
                .toList();

        return createOrder(itemGroupDTOs);
    }

    public OrderReportDTO getAllMyOrders(int userId) {
        List<Order> orders = orderRepository.getAllMyOrders(userId);
        double totalPrice = calculateTotalPriceForAllMyOrders(orders);
        return new OrderReportDTO(orderMapper.toDTO(orders), totalPrice);
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

    private List<ItemAmountPair> convertToItemAmountPairs(List<CreateItemGroupDTO> itemGroupDTOs) {
        return itemGroupDTOs.stream()
                .map(itemGroupDTO -> new ItemAmountPair(
                        new Item(itemRepository.getItemById(itemGroupDTO.getItemId()).orElseThrow(ItemNotFoundException::new)),
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
