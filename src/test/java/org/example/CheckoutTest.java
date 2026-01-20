package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CheckoutTest {

    @Test
    void totalForOneFruit() {
        var items = List.of("Orange");
        assertEquals(25, Checkout.totalPence(items));
        assertEquals("£0.25", Checkout.totalFormatted(items));
    }


    @Test
    void totalForOneOrangeAndOneApple() {
        var items = List.of("Orange", "Apple");
        assertEquals(85, Checkout.totalPence(items));
        assertEquals("£0.85", Checkout.totalFormatted(items));
    }

    @Test
    void totalForApplesAndOneOrange() {
        var items = List.of("Apple", "Apple", "Orange", "Apple");
        assertEquals(205, Checkout.totalPence(items));
        assertEquals("£2.05", Checkout.totalFormatted(items));
    }

    @Test
    void totalForOrangesAndOneApple() {
        var items = List.of("Orange", "Orange", "Apple", "Orange");
        assertEquals(135, Checkout.totalPence(items));
        assertEquals("£1.35", Checkout.totalFormatted(items));
    }

    @Test
    void nullListThrowsNpe() {
        assertThrows(NullPointerException.class, () -> Checkout.totalPence(null));
        assertThrows(NullPointerException.class, () -> Checkout.totalFormatted(null));
    }

    @Test
    void unknownItemThrowsIae() {
        var items = List.of("Banana");
        assertThrows(IllegalArgumentException.class, () -> Checkout.totalPence(items));
    }

    @Test
    void totalCase() {
        var items = List.of("oRange", "APPle");
        assertEquals(85, Checkout.totalPence(items));
        assertEquals("£0.85", Checkout.totalFormatted(items));
    }

    @Test
    void ignoreNulls() {
        List<String> items = new ArrayList<>();
        items.add("Orange");
        items.add(null);
        items.add("Apple");

        assertEquals(85, Checkout.totalPence(items));
        assertEquals("£0.85", Checkout.totalFormatted(items));
    }

}
