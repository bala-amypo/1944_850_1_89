package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;

import java.util.Comparator;
import java.util.List;

public class InvoiceCategorizationEngine {

    public Category determineCategory(
            Invoice invoice,
            List<CategorizationRule> rules) {

        if (rules == null || rules.isEmpty()) {
            return null;
        }

        return rules.stream()
                .sorted(Comparator.comparingInt(CategorizationRule::getPriority).reversed())
                .filter(rule -> {
                    String desc = invoice.getDescription();
                    String key = rule.getKeyword();

                    return switch (rule.getMatchType()) {
                        case "EXACT" -> desc.equalsIgnoreCase(key);
                        case "CONTAINS" -> desc.toLowerCase().contains(key.toLowerCase());
                        case "REGEX" -> desc.matches(key);
                        default -> false;
                    };
                })
                .map(CategorizationRule::getCategory)
                .findFirst()
                .orElse(null);
    }
}
