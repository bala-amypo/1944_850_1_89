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

        if (invoice == null || invoice.description == null || rules == null) {
            return defaultCategory();
        }

        String description = invoice.description.toLowerCase();

        // 1️⃣ EXACT MATCH
        for (CategorizationRule rule : rules) {
            if ("EXACT".equalsIgnoreCase(rule.conditionType)) {
                if (description.equals(rule.conditionValue.toLowerCase())) {
                    return rule.category;
                }
            }
        }

        // 2️⃣ CONTAINS MATCH
        for (CategorizationRule rule : rules) {
            if ("CONTAINS".equalsIgnoreCase(rule.conditionType)) {
                if (description.contains(rule.conditionValue.toLowerCase())) {
                    return rule.category;
                }
            }
        }

        // 3️⃣ REGEX MATCH ✅
        for (CategorizationRule rule : rules) {
            if ("REGEX".equalsIgnoreCase(rule.conditionType)) {
                Pattern pattern = Pattern.compile(
                        rule.conditionValue,
                        Pattern.CASE_INSENSITIVE
                );
                Matcher matcher = pattern.matcher(description);

                if (matcher.find()) {
                    return rule.category;
                }
            }
        }

        // 4️⃣ FALLBACK (NEVER NULL)
        return defaultCategory();
    }

    private Category defaultCategory() {
        Category category = new Category();
        category.categoryName = "Uncategorized";
        return category;
    }
}
