package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class InvoiceCategorizationEngine {

    public String categorize(String description) {
        if (description == null) {
            return "Uncategorized";
        }

        description = description.toLowerCase();

        if (description.contains("food")) {
            return "Food";
        } else if (description.contains("travel")) {
            return "Travel";
        } else if (description.contains("office")) {
            return "Office";
        }

        return "Others";
    }
}
