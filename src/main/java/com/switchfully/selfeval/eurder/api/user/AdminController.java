package com.switchfully.selfeval.eurder.api.user;

import com.switchfully.selfeval.eurder.domain.item.Item;
import com.switchfully.selfeval.eurder.domain.item.ItemRepository;
import com.switchfully.selfeval.eurder.domain.user.User;
import com.switchfully.selfeval.eurder.domain.user.UserRepository;
import com.switchfully.selfeval.eurder.domain.user.role.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    public AdminController(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
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
    public Item addItem(@RequestBody Item newItem){
        return itemRepository.addItem(newItem);
    }
}
