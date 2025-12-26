package com.example.demo.service;

import com.example.demo.model.CategorizationRule;

import java.util.List;

public interface CategorizationRuleService {

    CategorizationRule createRule(Long categoryId, CategorizationRule rule);

    CategorizationRule updateRule(Long ruleId, CategorizationRule rule);

    CategorizationRule getRuleById(Long ruleId);

    List<CategorizationRule> getAllRules();

    void deleteRule(Long ruleId);
}
