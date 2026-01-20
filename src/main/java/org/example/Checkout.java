package org.example;

import java.util.List;
import java.util.Objects;

public final class Checkout {

    private static final int PRICE_APPLE_PENCE = 60;
    private static final int PRICE_ORANGE_PENCE = 25;

    private Checkout() {

    }

    public static int totalPence(List<String> items) {

        Objects.requireNonNull(items, "items must not be null");


        int appleCount = 0;
        int orangeCount = 0;

        for (String fruit : items) {

            if (fruit == null) continue;

            String item = fruit.trim().toLowerCase();

            switch (item) {
                case "apple":
                    appleCount++;
                    break;
                case "orange":
                    orangeCount++;
                    break;
                default:
                    throw new IllegalArgumentException("Unknown item: " + fruit);
            }
        }

        // BOGOF on apples
        int chargedApples = (appleCount + 1) / 2;

        // 3 for the price of 2 on oranges
        int chargedOranges = (orangeCount / 3) * 2 + (orangeCount % 3);

        return (chargedApples * PRICE_APPLE_PENCE) + (chargedOranges * PRICE_ORANGE_PENCE);
    }
    public static String totalFormatted(List<String> items) {
        int totalPence = totalPence(items);
        int pounds = totalPence / 100;
        int pence = totalPence % 100;
        return String.format("£%d.%02d", pounds, pence);
    }
}
