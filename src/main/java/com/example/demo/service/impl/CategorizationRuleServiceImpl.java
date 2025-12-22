package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.CategorizationRuleService;

@Service
public class CategorizationRuleServiceImpl implements CategorizationRuleService {

    @Override
    public String getAllRules() {
        return "List of categorization rules";
    }
}
