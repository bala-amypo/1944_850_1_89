package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.Invoice;
import com.example.demo.model.CategorizationRule;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class InvoiceCategorizationEngine {

    public Category determineCategory(Invoice invoice, List<CategorizationRule> rules) {
        if (invoice == null || invoice.getDescription() == null || rules == null || rules.isEmpty()) {
            return null;
        }

        // Sort rules by priority in descending order (highest first)
        rules.sort((r1, r2) -> Integer.compare(r2.getPriority(), r1.getPriority()));

        String description = invoice.getDescription();

        for (CategorizationRule rule : rules) {
            if (matchesRule(description, rule)) {
                return rule.getCategory();
            }
        }

        return null;
    }

    private boolean matchesRule(String description, CategorizationRule rule) {
        String keyword = rule.getKeyword();
        String matchType = rule.getMatchType();

        if (keyword == null || matchType == null) {
            return false;
        }

        switch (matchType.toUpperCase()) {
            case "EXACT":
                return description.equalsIgnoreCase(keyword);
            case "CONTAINS":
                return description.toLowerCase().contains(keyword.toLowerCase());
            case "REGEX":
                try {
                    return Pattern.compile(keyword).matcher(description).find();
                } catch (Exception e) {
                    return false;
                }
            default:
                return false;
        }
    }
}