package com.switchfully.selfeval.eurder.domain.user;

public class Address {
    private final String streetName;
    private final int streetNumber;
    private final String postalCode;
    private final String city;

    public Address(String streetName, int streetNumber, String postalCode, String city) {
        if (!isValidInput(streetName,streetNumber,postalCode,city)){
            throw new IllegalArgumentException("Incorrect input");
        }
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
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
    private boolean isValidInput(String streetName,int streetNumber,String postalCode,String city){
        if (streetName == null || streetName.isEmpty()){
            return false;
        }
        if (streetNumber<=0){
            return false;
        }
        if (postalCode==null || postalCode.isEmpty()){
            return false;
        }
        if (city==null || city.isEmpty()){
            return false;
        }

        return true;
    }
}
