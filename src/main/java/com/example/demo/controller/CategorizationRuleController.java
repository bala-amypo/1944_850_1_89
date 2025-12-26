package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {

    private final CategorizationRuleService ruleService;

    public CategorizationRuleController(CategorizationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping("/category/{categoryId}")
    public CategorizationRule createRule(
            @PathVariable Long categoryId,
            @RequestBody CategorizationRule rule) {
        return ruleService.createRule(categoryId, rule);
    }

    @PutMapping("/{ruleId}")
    public CategorizationRule updateRule(
            @PathVariable Long ruleId,
            @RequestBody CategorizationRule rule) {
        return ruleService.updateRule(ruleId, rule);
    }

    @GetMapping
    public List<CategorizationRule> getAllRules() {
        return ruleService.getAllRules();
    }

    @DeleteMapping("/{ruleId}")
    public void deleteRule(@PathVariable Long ruleId) {
        ruleService.deleteRule(ruleId);
    }
}
