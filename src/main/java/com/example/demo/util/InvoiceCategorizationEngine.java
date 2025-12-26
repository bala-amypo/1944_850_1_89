package com.example.demo.util;

public class InvoiceCategorizationEngine {

    public static String categorize(String description) {
        if (description == null) return "UNKNOWN";

        description = description.toLowerCase();

        if (description.contains("food") || description.contains("restaurant"))
            return "FOOD";
        if (description.contains("taxi") || description.contains("uber"))
            return "TRANSPORT";
        if (description.contains("rent"))
            return "HOUSING";

        return "OTHER";
    }
}
