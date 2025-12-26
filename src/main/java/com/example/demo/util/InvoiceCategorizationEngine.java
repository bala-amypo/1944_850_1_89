package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class InvoiceCategorizationEngine {

    /**
     * Determines category based on rules.
     * Rules are evaluated by priority (higher first).
     */
    public Category determineCategory(Invoice invoice,
                                      List<CategorizationRule> rules) {

        if (invoice == null || rules == null || rules.isEmpty()) {
            return null;
        }

        String description = invoice.getDescription();
        if (description == null) {
            return null;
        }

        return rules.stream()
                .sorted(Comparator.comparingInt(
                        CategorizationRule::getPriority).reversed())
                .filter(rule -> matches(rule, description))
                .map(CategorizationRule::getCategory)
                .findFirst()
                .orElse(null);
    }

    // ---------------- PRIVATE HELPERS ----------------

    private boolean matches(CategorizationRule rule, String description) {

        if (rule.getKeyword() == null || rule.getMatchType() == null) {
            return false;
        }

        String keyword = rule.getKeyword();
        String matchType = rule.getMatchType().toUpperCase();

        switch (matchType) {

            case "EXACT":
                return description.equalsIgnoreCase(keyword);

            case "CONTAINS":
                return description.toLowerCase()
                        .contains(keyword.toLowerCase());

            case "REGEX":
                return Pattern.compile(keyword,
                        Pattern.CASE_INSENSITIVE)
                        .matcher(description)
                        .matches();

            default:
                return false;
        }
    }
}
