package com.example.ecommerce.service;

import com.example.ecommerce.model.Category;

import java.util.Optional;
import java.util.List;

public interface CategoryService {
	
    public Category saveCategory(Category category);
	public List<Category> saveCategories(List<Category> categories);
    public List<Category> getAll();
    public Optional<Category> getByCategoryId(int id);
    public Optional<Category> getByCategoryName(String categoryName);
	public String deleteCategory(int id);
	public Category updateCategory(Category category);
}
