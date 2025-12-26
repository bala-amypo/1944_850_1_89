package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorization-rules")
@Tag(name = "Categorization Rules Endpoints")
public class CategorizationRuleController {

    private final CategorizationRuleRepository ruleRepository;

    public CategorizationRuleController(CategorizationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Operation(summary = "Create categorization rule")
    @PostMapping
    public ResponseEntity<CategorizationRule> createRule(
            @RequestBody CategorizationRule rule) {
        return ResponseEntity.ok(ruleRepository.save(rule));
    }

    @Operation(summary = "List all rules")
    @GetMapping
    public ResponseEntity<List<CategorizationRule>> getAllRules() {
        return ResponseEntity.ok(ruleRepository.findAll());
    }
}
