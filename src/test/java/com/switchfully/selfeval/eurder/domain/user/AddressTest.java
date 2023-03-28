package com.switchfully.selfeval.eurder.domain.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    @Test
    void givenAnAddress_getStreetNameReturnsTheStreetName() {
        Address address = new Address("newStraat",36,"3000","Leuven");

        String actualStreetName = address.getStreetName();
        String expectedStreetName = "newStraat";

        Assertions.assertEquals(expectedStreetName,actualStreetName);
    }

    @Test
    void creatingAnAddressObjectUsingNullValues_shouldThrowAnException() {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,()->{
            Address address = new Address(null,36,"3000","Leuven");
        });
        Assertions.assertEquals("Incorrect input",exception.getMessage());
    }
    @Test
    void creatingAnAddressObjectUsingZeroValue_shouldThrowAnException() {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,()->{
            Address address = new Address("OudStraat",0,"3000","Leuven");
        });
        Assertions.assertEquals("Incorrect input",exception.getMessage());
    }
}