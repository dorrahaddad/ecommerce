package com.example.ecommerce.controller;

import com.example.ecommerce.service.CategoryService;
import com.example.ecommerce.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
	private CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Category category) {
        categoryService.add(category);
        return ResponseEntity.ok("Category Name Already In Use!");
    }

    @GetMapping("/getByCategoryName")
    public Category getByCategoryName(String categoryName) {
        return categoryService.getByCategoryName(categoryName);
    }
}