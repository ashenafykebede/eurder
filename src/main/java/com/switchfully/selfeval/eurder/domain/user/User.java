package com.switchfully.selfeval.eurder.domain.user;

import com.switchfully.selfeval.eurder.domain.user.role.Feature;
import com.switchfully.selfeval.eurder.domain.user.role.Role;

public abstract class User {
    private final int userID;
    private final String  firstName;
    private final String lastName;
    private final String password;
    private final Role role;
    private final Contact contact;
    private static int idGenerator=0;


    public User(String firstName, String lastName, Contact contact, String password, Role role) {
        this.userID = ++idGenerator;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.password = password;
        this.role = role;
    }

    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact getContact() {
        return contact;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
    public boolean canHaveAccessTo(Feature feature) {
        return role.canAccess(feature);
    }

    public boolean doesPasswordMatch(String password) {
        return this.password.equals(password);
    }
}
