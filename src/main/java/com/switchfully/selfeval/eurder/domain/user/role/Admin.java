package com.switchfully.selfeval.eurder.domain.user.role;

import com.switchfully.selfeval.eurder.domain.user.Contact;
import com.switchfully.selfeval.eurder.domain.user.User;

public class Admin extends User {
    public Admin(String firstName, String lastName, Contact contact, String password) {
        super(firstName, lastName, contact, password, Role.Admin);
    }
}
