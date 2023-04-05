package com.switchfully.selfeval.eurder.service.user;

import com.switchfully.selfeval.eurder.domain.user.UserRepository;
import com.switchfully.selfeval.eurder.domain.user.role.Customer;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Customer register(Customer newCustomer) {
       return userRepository.register(newCustomer);
    }
}
