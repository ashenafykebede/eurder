package com.switchfully.selfeval.eurder.domain.user;

public class Address {
    private final String streetName;
    private final int streetNumber;
    private final String postalCode;
    private final String city;

    public Address(String streetName, int streetNumber, String postalCode, String city) {
        if (!isCorrectAddress(streetName,streetNumber,postalCode,city)) {
            throw new IllegalArgumentException("Incorrect input");
        }
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    public boolean isCorrectAddress(String streetName, int streetNumber, String postalCode, String city) {
        return isValidStreetName(streetName)&&
                isValidStreetNumber(streetNumber)&&
                isValidPostalCode(postalCode)&&
                isValidCity(city);

    }

    private boolean isValidStreetName(String streetName) {
        return streetName != null && !streetName.isEmpty();
    }

    private boolean isValidStreetNumber(int streetNumber) {
        return streetNumber > 0;
    }

    private boolean isValidPostalCode(String postalCode) {
        return postalCode != null && !postalCode.isEmpty();
    }

    private boolean isValidCity(String city) {
        return city != null && !city.isEmpty();
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

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", streetNumber=" + streetNumber +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
