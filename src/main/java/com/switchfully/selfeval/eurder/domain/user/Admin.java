package com.switchfully.selfeval.eurder.domain.user;

import com.switchfully.selfeval.eurder.domain.user.role.Role;

public class Admin extends User{
    public Admin(String firstName, String lastName, Contact contact, String password) {
        super(firstName, lastName, contact, password, Role.Admin);
    }
}
