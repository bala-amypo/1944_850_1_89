package com.example.demo.impl;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;

import java.util.List;

public class CategorizationRuleServiceImpl {

    private final CategorizationRuleRepository ruleRepository;

    public CategorizationRuleServiceImpl(
            CategorizationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public List<CategorizationRule> getMatchingRules(String description) {
        return ruleRepository.findMatchingRulesByDescription(description);
    }
}
