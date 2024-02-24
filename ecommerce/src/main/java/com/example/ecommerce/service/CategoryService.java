package com.example.ecommerce.service;

import com.example.ecommerce.model.Category;

import java.util.List;

public interface CategoryService {
    Category add(Category category);
    List<Category> getAll();
    Category getByCategoryName(String categoryName);
}
