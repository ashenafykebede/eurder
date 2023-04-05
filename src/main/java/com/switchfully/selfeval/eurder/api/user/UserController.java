package com.switchfully.selfeval.eurder.api.user;

import com.switchfully.selfeval.eurder.domain.user.role.Customer;
import com.switchfully.selfeval.eurder.service.user.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(consumes ="application/json" ,produces = "application/json")
    public Customer register(@RequestBody Customer newCustomer) {
        return userService.register(newCustomer);
    }
}
