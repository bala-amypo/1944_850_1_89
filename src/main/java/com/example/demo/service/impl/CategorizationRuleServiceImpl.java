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
// 
package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Category;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class CategorizationRuleServiceImpl implements CategorizationRuleService {

    private final CategorizationRuleRepository ruleRepository;
    private final CategoryRepository categoryRepository;

    public CategorizationRuleServiceImpl(
            CategorizationRuleRepository ruleRepository,
            CategoryRepository categoryRepository) {
        this.ruleRepository = ruleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategorizationRule createRule(Long categoryId, CategorizationRule rule) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        rule.setCategory(category);
        return ruleRepository.save(rule);
    }

    @Override
    public CategorizationRule updateRule(Long ruleId, CategorizationRule rule) {
        CategorizationRule existing = ruleRepository.findById(ruleId)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));

        existing.setKeyword(rule.getKeyword());
        existing.setMatchType(rule.getMatchType());
        existing.setPriority(rule.getPriority());

        return ruleRepository.save(existing);
    }

    @Override
    public CategorizationRule getRuleById(Long ruleId) {
        return ruleRepository.findById(ruleId)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
    }

    @Override
    public List<CategorizationRule> getAllRules() {
        return ruleRepository.findAll();
    }

    @Override
    public void deleteRule(Long ruleId) {
        ruleRepository.deleteById(ruleId);
    }

    // ✅ THIS IS THE RULE ENGINE METHOD REQUIRED BY TESTS
    @Override
    public Category categorize(String description) {

        List<CategorizationRule> rules = ruleRepository.findAll();

        if (rules == null || rules.isEmpty()) {
            return null;
        }

        for (CategorizationRule rule : rules) {

            // REGEX match
            if ("REGEX".equalsIgnoreCase(rule.getMatchType())) {
                Pattern pattern = Pattern.compile(rule.getKeyword());
                if (pattern.matcher(description).matches()) {
                    return rule.getCategory();
                }
            }

            // EXACT match
            if ("EXACT".equalsIgnoreCase(rule.getMatchType())) {
                if (description.equals(rule.getKeyword())) {
                    return rule.getCategory();
                }
            }
        }

        return null;
    }
}

