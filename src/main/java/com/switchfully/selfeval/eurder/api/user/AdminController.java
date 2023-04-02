package com.switchfully.selfeval.eurder.api.user;

import com.switchfully.selfeval.eurder.api.dto.ItemDTO;
import com.switchfully.selfeval.eurder.api.dto.UpdateItemDTO;
import com.switchfully.selfeval.eurder.domain.item.Item;
import com.switchfully.selfeval.eurder.domain.item.ItemRepository;
import com.switchfully.selfeval.eurder.domain.order.OrderRepository;
import com.switchfully.selfeval.eurder.domain.user.UserRepository;
import com.switchfully.selfeval.eurder.domain.user.role.Customer;
import com.switchfully.selfeval.eurder.service.item.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final ItemService itemService;

    public AdminController(UserRepository userRepository, ItemRepository itemRepository, OrderRepository orderRepository, ItemService itemService) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
        this.itemService = itemService;
    }
//Customers
    @GetMapping("customers")
    public List<Customer> getAllCustomers(){
        return userRepository.getAllCustomers();
    }
    @GetMapping("customers/{id}")
    public Customer getACustomer(@PathVariable int id){
        return userRepository.getACustomer(id);
    }

    //   Items
    @PostMapping(path = "items",consumes = "application/json",produces = "application/json")
    public ItemDTO addItem(@RequestBody Item newItem){
        return itemService.addItem(newItem);
    }
    @PutMapping(path = "items/{id}",consumes = "application/json",produces = "application/json")
    public ItemDTO updateItem(@PathVariable int id,@RequestBody UpdateItemDTO updateItemDTO){
        return itemService.updateItem(id,updateItemDTO);
    }
}
