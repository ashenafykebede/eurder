package com.switchfully.selfeval.eurder.domain.user;

import com.switchfully.selfeval.eurder.domain.user.role.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private final ConcurrentHashMap<Integer,Customer> customersDatabase = new ConcurrentHashMap<>();
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customersDatabase.values());
    }

    public Customer register(Customer newCustomer) {
        customersDatabase.put(newCustomer.getUserID(),newCustomer);
        return customersDatabase.get(newCustomer.getUserID());
    }

    public Customer getACustomer(int id) {
        return customersDatabase.get(id);
    }
}
