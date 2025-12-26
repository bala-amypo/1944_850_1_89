package com.example.demo.repository;

import com.example.demo.model.CategorizationRule;
import java.util.List;

public interface CategorizationRuleRepository {

    List<CategorizationRule> findMatchingRulesByDescription(String description);
}
