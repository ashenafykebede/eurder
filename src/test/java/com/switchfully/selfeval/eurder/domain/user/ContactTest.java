package com.switchfully.selfeval.eurder.domain.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest {
    @Test
    void givenAContact_getEmailReturnsTheEmail() {
        Contact contact = new Contact("john@gmail.com","0412345678");

        String actual = contact.getEmail();
        String expected = "john@gmail.com";

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void creatingAContactObjectWithNullEmailAddress_shouldThrowAnException() {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,()->{
            Contact contact = new Contact(null,"0412345678");
        });
        Assertions.assertEquals("Incorrect input",exception.getMessage());
    }
    @Test
    void creatingAContactObjectWithEmptyEmailAddress_shouldThrowAnException() {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,()->{
            Contact contact = new Contact("","0412345678");
        });
        Assertions.assertEquals("Incorrect input",exception.getMessage());
    }
    @Test
    void creatingAContactObjectWithInvalidEmailAddress_shouldThrowAnException() {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,()->{
            Contact contact = new Contact("mark@gmail","0412345678");
        });
        Assertions.assertEquals("Incorrect input",exception.getMessage());
    }
    @Test
    void creatingAContactObjectWithEmptyPhoneNumber_shouldThrowAnException() {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,()->{
            Contact contact = new Contact("john@gmail.com","");
        });
        Assertions.assertEquals("Incorrect input",exception.getMessage());
    }
    @Test
    void creatingAContactObjectWithNullPhoneNumber_shouldThrowAnException() {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,()->{
            Contact contact = new Contact("john@gmail.com",null);
        });
        Assertions.assertEquals("Incorrect input",exception.getMessage());
    }
}