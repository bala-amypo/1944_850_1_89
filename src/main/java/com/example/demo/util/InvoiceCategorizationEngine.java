package com.example.demo.util;

import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class InvoiceCategorizationEngine {

    // ✅ REQUIRED BY TESTS
    public String determineCategory(Invoice invoice, List<CategorizationRule> rules) {

        if (rules == null || rules.isEmpty() || invoice == null) {
            return null;
        }

        return rules.stream()
                .filter(rule ->
                        invoice.getDescription() != null &&
                        rule.getKeyword() != null &&
                        invoice.getDescription().toLowerCase()
                                .contains(rule.getKeyword().toLowerCase())
                )
                .sorted(Comparator.comparingInt(CategorizationRule::getPriority))
                .map(rule -> rule.getCategory().getCategoryName())
                .findFirst()
                .orElse(null);
    }
}
