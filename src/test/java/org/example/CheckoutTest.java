package org.example;

import org.junit.jupiter.api.Test;
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
        // 3 apples -> charged for 2 (2 * 60 = 120), 1 orange = 25 -> total 145
        assertEquals(145, Checkout.totalPence(items));
        assertEquals("£1.45", Checkout.totalFormatted(items));
    }

    @Test
    void totalForOrangesAndOneApple() {
        var items = List.of("Orange", "Orange", "Apple", "Orange");
        // 3 oranges -> charged for 2 (2 * 25 = 50), 1 apple = 60 -> total 110
        assertEquals(110, Checkout.totalPence(items));
        assertEquals("£1.10", Checkout.totalFormatted(items));
    }

    @Test
    void nullListThrowsNpe() {
        assertThrows(NullPointerException.class, () -> Checkout.totalPence(null));
        assertThrows(NullPointerException.class, () -> Checkout.totalFormatted(null));
    }

    @Test
    void unknownFruitThrowsIae() {
        var items = List.of("Banana");
        assertThrows(IllegalArgumentException.class, () -> Checkout.totalPence(items));
    }

    @Test
    void totalWithMixedCase() {
        var items = List.of("oRange", "APPle");
        assertEquals(85, Checkout.totalPence(items));
        assertEquals("£0.85", Checkout.totalFormatted(items));
    }

}