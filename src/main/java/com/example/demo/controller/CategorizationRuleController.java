package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rules")
public class CategorizationRuleController {

    @PostMapping
    public CategorizationRule createRule(@RequestBody CategorizationRule rule) {
        return rule;
    }

    @GetMapping
    public List<CategorizationRule> getAllRules() {
        return List.of();
    }
}
