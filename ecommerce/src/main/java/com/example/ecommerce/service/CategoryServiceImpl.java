package com.example.ecommerce.service;

import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	@Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category add(Category category) {
        if(categoryRepository.findByCategoryName(category.getCategoryName()) != null) {
            return null;
        }
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category getByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

}