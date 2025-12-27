public interface CategorizationRuleService {
    CategorizationRule createRule(Long categoryId, CategorizationRule rule);
    CategorizationRule updateRule(Long ruleId, CategorizationRule rule);
    CategorizationRule getRuleById(Long ruleId);
    List<CategorizationRule> getAllRules();
    void deleteRule(Long ruleId);
    Category categorize(String description); // <-- THIS MUST EXIST
}
