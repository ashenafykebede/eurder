package com.switchfully.selfeval.eurder.domain.item;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void gvenAnItem_getAmountInStock_returnsTheAmount() {
        Item item = new Item("Gsm","Latest samsung series",599.9f,25);

        int actual = item.getAmountInStock();
        int expected = 25;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void creatingAnItemWithInvalidName_shouldThrowAnException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,()->{
            Item item = new Item(null,"Latest samsung series",599.9f,25);
        });
        Assertions.assertEquals("Incorrect input", exception.getMessage());
    }
    @Test
    void creatingAnItemWithInvalidPrice_shouldThrowAnException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,()->{
            Item item = new Item("Cellphone","Latest samsung series",-250f,25);
        });
        Assertions.assertEquals("Incorrect input", exception.getMessage());
    }
    @Test
    void creatingAnItemWithInvalidAmount_shouldThrowAnException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,()->{
            Item item = new Item("Cellphone","Latest samsung series",599.9f,-100);
        });
        Assertions.assertEquals("Incorrect input", exception.getMessage());
    }
}