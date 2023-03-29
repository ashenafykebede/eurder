package com.switchfully.selfeval.eurder.domain.user;

import com.switchfully.selfeval.eurder.domain.user.role.Role;

public class Customer extends User{
    private Address address;

    public Customer(String firstName, String lastName,String password, Contact contact, Address address) {
        super(firstName, lastName, contact, password, Role.Customer);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
