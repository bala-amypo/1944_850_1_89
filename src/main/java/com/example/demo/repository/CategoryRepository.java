package com.example.demo.repository;

import com.example.demo.model.Category;
import java.util.Optional;

public interface CategoryRepository {

    Optional<Category> findById(Long id);
}
