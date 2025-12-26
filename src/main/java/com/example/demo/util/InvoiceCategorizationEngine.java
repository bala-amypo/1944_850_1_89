package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.Invoice;
import com.example.demo.model.CategorizationRule;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceCategorizationEngine {

    public Category categorize(Invoice invoice, List<CategorizationRule> rules) {

        if (rules == null || rules.isEmpty()) {
            return null;
        }

        String description = invoice.getDescription();
        if (description == null) {
            return null;
        }

        for (CategorizationRule rule : rules) {
            if (description.toLowerCase()
                    .contains(rule.getKeyword().toLowerCase())) {
                return rule.getCategory();
            }
        }

        return null; // no match found
    }
}
