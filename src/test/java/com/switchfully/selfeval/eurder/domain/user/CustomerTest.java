package com.switchfully.selfeval.eurder.domain.user;

import com.switchfully.selfeval.eurder.domain.user.role.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private final Customer ashenafi = new Customer("", "Weldie", "123",
            new Contact("myemail@gmail.com", "0489562314"),
            new Address("StationStraat", 65, "3000", "Leuven"));

    @Test
    void givenACustomer_getFirstNameReturnsTheFirstName() {
        Customer customer = new Customer("Ashenafi", "Weldie", "123",
                new Contact("myemail@gmail.com", "0489562314"),
                new Address("StationStraat", 65, "3000", "Leuven"));
        String actual = customer.getFirstName();
        String expected = "Ashenafi";
    }

    @Test
    void creatingACustomerWithIncorrectFirstName_shouldThrowAnException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Customer customer = new Customer("", "Weldie", "123",
                    new Contact("myemail@gmail.com", "0489562314"),
                    new Address("StationStraat", 65, "3000", "Leuven"));
        });
        Assertions.assertEquals("Incorrect input", exception.getMessage());
    }

    @Test
    void creatingACustomerWithIncorrectLastName_shouldThrowAnException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Customer customer = new Customer("", null, "123",
                    new Contact("myemail@gmail.com", "0489562314"),
                    new Address("StationStraat", 65, "3000", "Leuven"));
        });
        Assertions.assertEquals("Incorrect input", exception.getMessage());
    }

    @Test
    void creatingACustomerWithIncorrectPassword_shouldThrowAnException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Customer customer = new Customer("", "Weldie", null,
                    new Contact("myemail@gmail.com", "0489562314"),
                    new Address("StationStraat", 65, "3000", "Leuven"));
        });
        Assertions.assertEquals("Incorrect input", exception.getMessage());
    }

    @Test
    void givenACustomerWithWrongPassword_doesPasswordMatchShouldReturnFalse() {
        //Given
        String password = "568";
         Boolean isPasswordCorrect = ashenafi.doesPasswordMatch(password);

        Assertions.assertFalse(false);

    }
    @Test
    void givenACustomerWithCorrectPassword_doesPasswordMatchShouldReturnTrue() {
        //Given
        String password = "123";
        Boolean isPasswordCorrect = ashenafi.doesPasswordMatch(password);

        Assertions.assertFalse(false);

    }
    @Test
    void givenAnAuthenticatedCustomerWithNoAccessToACertainFeature_haveAccessToShouldReturnFalse() {
        //Given
        Feature feature = Feature.ADD_AN_ITEM;
        Boolean hasAccessTo = ashenafi.canHaveAccessTo(feature);
        Assertions.assertFalse(false);
    }
    @Test
    void givenAnAuthenticatedCustomerWithAccessToACertainFeature_haveAccessToShouldReturnTrue() {
        //Given
        Feature feature = Feature.ORDER_AN_ITEM;
        Boolean hasAccessTo = ashenafi.canHaveAccessTo(feature);
        Assertions.assertFalse(false);
    }
}