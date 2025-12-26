package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorization-rules")
public class CategorizationRuleController {

    private final CategorizationRuleRepository ruleRepository;

    public CategorizationRuleController(CategorizationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @PostMapping
    public ResponseEntity<CategorizationRule> createRule(
            @RequestBody CategorizationRule rule) {
        return ResponseEntity.ok(ruleRepository.save(rule));
    }

    @GetMapping
    public ResponseEntity<List<CategorizationRule>> getAllRules() {
        return ResponseEntity.ok(ruleRepository.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity<List<CategorizationRule>> searchRules(
            @RequestParam String description) {

        return ResponseEntity.ok(
                ruleRepository.findMatchingRulesByDescription(description)
        );
    }
}
