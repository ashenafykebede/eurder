package com.switchfully.selfeval.eurder.domain.user;

public class Address {
    private final String streetName;
    private final int streetNumber;
    private final String postalCode;
    private final String city;

    public Address(String streetName, int streetNumber, String postalCode, String city) {
        this.streetName = validateStreetName(streetName);
        this.streetNumber = validateStreetNumber(streetNumber);
        this.postalCode = validatePostalCode(postalCode);
        this.city = validateCity(city);
    }


    private String validateStreetName(String streetName) {
        if (streetName == null || streetName.isEmpty()) {
            throw new IllegalArgumentException("Incorrect input");
        }
        return streetName;
    }

    private int validateStreetNumber(int streetNumber) {
        if (streetNumber <= 0) {
            throw new IllegalArgumentException("Incorrect input");
        }
        return streetNumber;

    }
    private String validatePostalCode(String postalCode) {
        if (postalCode == null || postalCode.isEmpty()) {
            throw new IllegalArgumentException("Incorrect input");
        }
        return postalCode;
    }

    private String validateCity(String city) {
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("Incorrect input");
        }
        return city;
    }


    public String getStreetName() {
        return streetName;
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
