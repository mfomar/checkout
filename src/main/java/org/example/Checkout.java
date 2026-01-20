package org.example;

import java.util.List;
import java.util.Objects;

public final class Checkout {

    private static final int PRICE_APPLE_PENCE = 60;
    private static final int PRICE_ORANGE_PENCE = 25;

    private Checkout() {

    }

    public static int totalPence(List<String> fruits) {

        Objects.requireNonNull(fruits, "fruits must not be null");

        int total = 0;

        for (String fruit : fruits) {
            if (fruit == null) continue;

            String item = fruit.trim().toLowerCase();

            switch (item) {
                case "apple":
                    total += PRICE_APPLE_PENCE;
                    break;
                case "orange":
                    total += PRICE_ORANGE_PENCE;
                    break;
                default:
                    throw new IllegalArgumentException("Unknown item: " + fruit);
            }
        }

        return total;
    }

    public static String totalFormatted(List<String> items) {
        int totalPence = totalPence(items);
        int pounds = totalPence / 100;
        int pence = totalPence % 100;
        return String.format("£%d.%02d", pounds, pence);
    }
}
