package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Comparator;

@Component
public class InvoiceCategorizationEngine {
    public Category determineCategory(Invoice invoice, List<CategorizationRule> rules) {
        if (rules == null || rules.isEmpty() || invoice.getDescription() == null) return null;

        return rules.stream()
                .sorted(Comparator.comparingInt(CategorizationRule::getPriority).reversed())
                .filter(rule -> matches(invoice.getDescription(), rule))
                .map(CategorizationRule::getCategory)
                .findFirst()
                .orElse(null);
    }

    private boolean matches(String desc, CategorizationRule rule) {
        String kw = rule.getKeyword();
        return switch (rule.getMatchType().toUpperCase()) {
            case "EXACT" -> desc.equalsIgnoreCase(kw);
            case "CONTAINS" -> desc.toLowerCase().contains(kw.toLowerCase());
            case "REGEX" -> desc.matches(kw);
            default -> false;
        };
    }
}