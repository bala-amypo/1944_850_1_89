package com.example.demo.util;

import com.example.demo.model.Invoice;
import com.example.demo.model.CategorizationRule;

import java.util.List;

public class InvoiceCategorizationEngine {

    public String determineCategory(Invoice invoice,
                                    List<CategorizationRule> rules) {

        if (invoice == null || rules == null || rules.isEmpty()) {
            return "UNCATEGORIZED";
        }

        String description = invoice.getDescription();
        if (description == null) {
            return "UNCATEGORIZED";
        }

        description = description.toLowerCase();

        for (CategorizationRule rule : rules) {
            if (description.contains(rule.getKeyword().toLowerCase())) {
                return rule.getCategory();
            }
        }

        return "OTHER";
    }
}
