package com.switchfully.selfeval.eurder.domain.user;

import com.switchfully.selfeval.eurder.domain.user.role.Role;
import com.switchfully.selfeval.eurder.service.security.Feature;

public abstract class User {
    private final int userID;
    private final String  firstName;
    private final String lastName;
    private final String password;
    private final Role role;
    private final Contact contact;
    private static int idGenerator=0;


    public User(String firstName, String lastName, Contact contact, String password, Role role) {
//        if (!isCorrectInput(firstName,lastName,password)){
//            throw new IllegalArgumentException("Incorrect input");
//        }
        this.userID = ++idGenerator;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.password = password;
        this.role = role;
    }

    private boolean isCorrectInput(String firstName, String lastName,String password) {
        return isCorrectFirstName(firstName)&&
                isCorrectLastName(lastName)&&
                isValidPassword(password);
    }

    private boolean isCorrectFirstName(String firstName) {
        return firstName != null && !firstName.isEmpty();
    }
    private boolean isCorrectLastName(String lastName) {
        return lastName != null && !lastName.isEmpty();
    }
    private boolean isValidPassword(String password) {
        return password != null && !password.isEmpty();
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
