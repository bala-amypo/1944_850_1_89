// package com.example.demo.service.impl;

// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.model.CategorizationRule;
// import com.example.demo.model.Category;
// import com.example.demo.repository.CategorizationRuleRepository;
// import com.example.demo.repository.CategoryRepository;
// import com.example.demo.service.CategorizationRuleService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class CategorizationRuleServiceImpl implements CategorizationRuleService {

//     private final CategorizationRuleRepository ruleRepository;
//     private final CategoryRepository categoryRepository;

//     public CategorizationRuleServiceImpl(
//             CategorizationRuleRepository ruleRepository,
//             CategoryRepository categoryRepository) {
//         this.ruleRepository = ruleRepository;
//         this.categoryRepository = categoryRepository;
//     }

//     @Override
//     public CategorizationRule createRule(Long categoryId, CategorizationRule rule) {
//         Category category = categoryRepository.findById(categoryId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

//         rule.setCategory(category);
//         return ruleRepository.save(rule);
//     }

//     @Override
//     public CategorizationRule updateRule(Long ruleId, CategorizationRule rule) {
//         CategorizationRule existing = ruleRepository.findById(ruleId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));

//         existing.setKeyword(rule.getKeyword());
//         existing.setMatchType(rule.getMatchType());
//         existing.setPriority(rule.getPriority());

//         return ruleRepository.save(existing);
//     }

//     @Override
//     public CategorizationRule getRuleById(Long ruleId) {
//         return ruleRepository.findById(ruleId)
//                 .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
//     }

//     @Override
//     public List<CategorizationRule> getAllRules() {
//         return ruleRepository.findAll();
//     }

//     @Override
//     public void deleteRule(Long ruleId) {
//         ruleRepository.deleteById(ruleId);
//     }
// }


package com.example.demo.service;

import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Category;

import java.util.List;

public interface CategorizationRuleService {

    CategorizationRule createRule(Long categoryId, CategorizationRule rule);

    CategorizationRule updateRule(Long ruleId, CategorizationRule rule);

    CategorizationRule getRuleById(Long ruleId);

    List<CategorizationRule> getAllRules();

    void deleteRule(Long ruleId);

    @Override
public Category categorize(String description) {
    if (description == null || description.trim().isEmpty()) {
        return null;
    }

    List<CategorizationRule> rules = ruleRepository.findAll();
    if (rules == null || rules.isEmpty()) {
        return null;
    }

    rules.sort((r1, r2) -> Integer.compare(r2.getPriority(), r1.getPriority()));

    for (CategorizationRule rule : rules) {
        if (rule.getKeyword() == null || rule.getMatchType() == null || rule.getCategory() == null) {
            continue;
        }

        if ("REGEX".equalsIgnoreCase(rule.getMatchType())) {
            if (Pattern.compile(rule.getKeyword(), Pattern.CASE_INSENSITIVE)
                    .matcher(description).find()) {
                return rule.getCategory();
            }
        } else if ("EXACT".equalsIgnoreCase(rule.getMatchType())) {
            if (description.equalsIgnoreCase(rule.getKeyword())) {
                return rule.getCategory();
            }
        }
    }

    return null;
}

    Category categorize(String description);
}
