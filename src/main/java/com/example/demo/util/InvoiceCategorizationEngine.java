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
import com.example.demo.model.Rule;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.RuleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class InvoiceCategorizationEngine {

    private final RuleRepository ruleRepository;
    private final CategoryRepository categoryRepository;

    public InvoiceCategorizationEngine(RuleRepository ruleRepository,
                                       CategoryRepository categoryRepository) {
        this.ruleRepository = ruleRepository;
        this.categoryRepository = categoryRepository;
    }

    /**
     * Categorize invoice based on description
     */
    public Category categorize(String description) {

        if (description == null || description.isBlank()) {
            return getDefaultCategory();
        }

        String normalizedDescription = description.toLowerCase();

        List<Rule> rules = ruleRepository.findAll();

        // 1️⃣ EXACT MATCH
        for (Rule rule : rules) {
            if ("EXACT".equalsIgnoreCase(rule.getRuleType())) {
                if (normalizedDescription.equals(rule.getPattern().toLowerCase())) {
                    return rule.getCategory();
                }
            }
        }

        // 2️⃣ CONTAINS MATCH
        for (Rule rule : rules) {
            if ("CONTAINS".equalsIgnoreCase(rule.getRuleType())) {
                if (normalizedDescription.contains(rule.getPattern().toLowerCase())) {
                    return rule.getCategory();
                }
            }
        }

        // 3️⃣ REGEX MATCH (🔥 FIXED LOGIC)
        for (Rule rule : rules) {
            if ("REGEX".equalsIgnoreCase(rule.getRuleType())) {
                Pattern pattern = Pattern.compile(
                        rule.getPattern(),
                        Pattern.CASE_INSENSITIVE
                );
                Matcher matcher = pattern.matcher(normalizedDescription);

                if (matcher.find()) {
                    return rule.getCategory();
                }
            }
        }

        // 4️⃣ FALLBACK (NEVER RETURN NULL)
        return getDefaultCategory();
    }

    /**
     * Returns default category (Uncategorized)
     */
    private Category getDefaultCategory() {
        return categoryRepository
                .findByCategoryName("Uncategorized")
                .orElseGet(() -> {
                    Category category = new Category();
                    category.setCategoryName("Uncategorized");
                    return category;
                });
    }
}
