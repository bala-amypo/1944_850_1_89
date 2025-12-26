package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Comparator;

@Component // This allows Spring to find and inject this "bean"
public class InvoiceCategorizationEngine {

    /**
     * Determines the category for an invoice based on its description and provided rules.
     * Rules are processed based on priority (highest first).
     */
    public Category determineCategory(Invoice invoice, List<CategorizationRule> rules) {
        if (rules == null || rules.isEmpty() || invoice.getDescription() == null) {
            return null;
        }

        return rules.stream()
                .sorted(Comparator.comparingInt(CategorizationRule::getPriority).reversed())
                .filter(rule -> matches(invoice.getDescription(), rule))
                .map(CategorizationRule::getCategory)
                .findFirst()
                .orElse(null);
    }

    private boolean matches(String description, CategorizationRule rule) {
        String keyword = rule.getKeyword();
        String type = rule.getMatchType().toUpperCase();

        return switch (type) {
            case "EXACT" -> description.equalsIgnoreCase(keyword);
            case "CONTAINS" -> description.toLowerCase().contains(keyword.toLowerCase());
            case "REGEX" -> description.matches(keyword);
            default -> false;
        };
    }
}