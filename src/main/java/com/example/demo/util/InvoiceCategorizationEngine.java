package com.example.demo.util;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceCategorizationEngine {

    public Category determineCategory(Invoice invoice,
                                      List<CategorizationRule> rules) {

        if (invoice.getDescription() == null) {
            return null;
        }

        String description = invoice.getDescription().toLowerCase();

        for (CategorizationRule rule : rules) {
            if (rule.getKeyword() != null &&
                description.contains(rule.getKeyword().toLowerCase())) {

                return rule.getCategory();
            }
        }

        return null; // no matching rule
    }
}
