package com.switchfully.selfeval.eurder.domain.user;

public class Contact {
    private String email;
    private String phoneNumber;

    public Contact(String email, String phoneNumber) {
        this.email = validateEmail(email);
        this.phoneNumber = validatePhoneNumber(phoneNumber);
    }

    private String validatePhoneNumber(String phoneNumber) {
        if ( phoneNumber==null || phoneNumber.isEmpty()){
            throw new IllegalArgumentException("Incorrect input");
        }
        return phoneNumber;
    }

    private String validateEmail(String email) {
        if ( email==null || email.isEmpty() || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            throw new IllegalArgumentException("Incorrect input");
        }
        return email;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
