package com.switchfully.selfeval.eurder.api.user;

import com.switchfully.selfeval.eurder.domain.user.User;
import com.switchfully.selfeval.eurder.domain.user.UserRepository;
import com.switchfully.selfeval.eurder.domain.user.role.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(consumes ="application/json" ,produces = "application/json")
    public Customer register(@RequestBody Customer newCustomer) {
        return userRepository.register(newCustomer);
    }
}
