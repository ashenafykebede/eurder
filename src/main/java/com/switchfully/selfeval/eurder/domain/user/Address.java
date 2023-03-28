package com.switchfully.selfeval.eurder.domain.user;

public class Address {
    private final String streetName;
    private final int streetNumber;
    private final String postalCode;
    private final String city;

    public Address(String streetName, int streetNumber, String postalCode, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getStreetName() {
        return null;
    }

    public int getStreetNumber() {
        return 0;
    }

    public String getPostalCode() {
        return null;
    }

    public String getCity() {
        return null;
    }
}
