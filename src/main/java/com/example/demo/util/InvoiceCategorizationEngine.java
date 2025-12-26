package com.example.demo.util;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Component   // ✅ THIS IS THE FIX
public class InvoiceCategorizationEngine {

    public Category determineCategory(Invoice invoice,
                                      List<CategorizationRule> rules) {

        for (CategorizationRule rule : rules) {
            if (invoice.getAmount() >= rule.getMinAmount()
                    && invoice.getAmount() <= rule.getMaxAmount()) {
                return rule.getCategory();
            }
        }

        return null; // or default category if required
    }
}
