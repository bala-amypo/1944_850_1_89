package com.example.demo.entity;

public class CategorizationRule {

    private Long id;
    private String keyword;
    private String category;

    public CategorizationRule() {
    }

    public CategorizationRule(Long id, String keyword, String category) {
        this.id = id;
        this.keyword = keyword;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
