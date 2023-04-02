package com.switchfully.selfeval.eurder.domain.user;

import com.switchfully.selfeval.eurder.domain.user.role.Admin;
import com.switchfully.selfeval.eurder.domain.user.role.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final ConcurrentHashMap<Integer, Customer> customersDatabase = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, Admin> adminsDatabase = new ConcurrentHashMap<>();

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customersDatabase.values());
    }

    public Customer register(Customer newCustomer) {
        customersDatabase.put(newCustomer.getUserID(), newCustomer);
        return customersDatabase.get(newCustomer.getUserID());
    }

    public Customer getCustomerById(int id) {
        return customersDatabase.get(id);
    }

    private void addDefaultAdmin() {
        Admin admin = new Admin("John", "Doe", new Contact("john@gmail.com", "+3212345678"), "123");
        adminsDatabase.put(admin.getUserID(), admin);
    }

    public User getUserByEmail(String email) {
        return customersDatabase.values().stream()
                .filter(customer -> customer.getContact().getEmail().equals(email))
                .findFirst()
                .orElseThrow();
    }
}
