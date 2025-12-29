// package com.example.demo.util;

// import com.example.demo.model.*;
// import org.springframework.stereotype.Component;

// import java.util.List;

// @Component
// public class InvoiceCategorizationEngine {

//     public Category determineCategory(Invoice invoice,
//                                       List<CategorizationRule> rules) {

//         if (invoice.getDescription() == null) {
//             return null;
//         }

//         String description = invoice.getDescription().toLowerCase();

//         for (CategorizationRule rule : rules) {
//             if (rule.getKeyword() != null &&
//                 description.contains(rule.getKeyword().toLowerCase())) {

//                 return rule.getCategory();
//             }
//         }

//         return null; // no matching rule
//     }
// }


package com.example.demo.util;

import com.example.demo.model.Category;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class InvoiceCategorizationEngine {

    public Category determineCategory(Invoice invoice,
                                      List<CategorizationRule> rules) {

        // ✅ EDGE CASE: No rules → return NULL (TEST EXPECTS THIS)
        if (rules == null || rules.isEmpty()) {
            return null;
        }

        if (invoice == null || invoice.getDescription() == null) {
            return null;
        }

        String description = invoice.getDescription().toLowerCase();

        // 1️⃣ EXACT MATCH
        for (CategorizationRule rule : rules) {
            if ("EXACT".equalsIgnoreCase(rule.getMatchType())) {
                if (description.equals(rule.getKeyword().toLowerCase())) {
                    return rule.getCategory();
                }
            }
        }

        // 2️⃣ CONTAINS MATCH
        for (CategorizationRule rule : rules) {
            if ("CONTAINS".equalsIgnoreCase(rule.getMatchType())) {
                if (description.contains(rule.getKeyword().toLowerCase())) {
                    return rule.getCategory();
                }
            }
        }

        // 3️⃣ REGEX MATCH
        for (CategorizationRule rule : rules) {
            if ("REGEX".equalsIgnoreCase(rule.getMatchType())) {
                Pattern pattern = Pattern.compile(
                        rule.getKeyword(),
                        Pattern.CASE_INSENSITIVE
                );
                Matcher matcher = pattern.matcher(description);

                if (matcher.find()) {
                    return rule.getCategory();
                }
            }
        }

        // 4️⃣ RULES EXIST BUT NO MATCH → DEFAULT CATEGORY
        Category category = new Category();
        category.setCategoryName("Uncategorized");
        return category;
    }
}
