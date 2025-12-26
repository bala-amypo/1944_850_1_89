package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;

import java.util.List;

public class InvoiceCategorizationEngine {

    public Category determineCategory(Invoice invoice,
                                      List<CategorizationRule> rules) {

        if (invoice == null || rules == null || rules.isEmpty()) {
            return null;
        }

        String description = invoice.getDescription();
        if (description == null) {
            return null;
        }

        description = description.toLowerCase();

        for (CategorizationRule rule : rules) {
            if (description.contains(rule.getKeyword().toLowerCase())) {
                return rule.getCategory(); // ✅ returns Category
            }
        }

        return null; // unmatched
    }
}
