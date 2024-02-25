package com.example.ecommerce.controller;

import com.example.ecommerce.service.CategoryService;
import com.example.ecommerce.model.Category;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
	private CategoryService categoryService;

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return categoryService.getAll();
    }
    
    @GetMapping("/getCategoryByName/{categoryName}")
    public Optional<Category> getByCategoryName(@PathVariable String categoryName) {
        return categoryService.getByCategoryName(categoryName);
    }
    
    @GetMapping("/getCategoryById/{id}")
	public Optional<Category> findCategoryById(@PathVariable int id){
		return categoryService.getByCategoryId(id);
	}

    @PostMapping("/addCategory")
	public Category addCategory(@RequestBody Category category){
		return categoryService.saveCategory(category);
	}
	
	@PostMapping("/addCategories")
	public List<Category> addCategories(@RequestBody List<Category> categories){
		return categoryService.saveCategories(categories);
	}
    
    @PutMapping("/update")
	public Category updateCategory(@RequestBody Category category) {
		return categoryService.updateCategory(category);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteCategory(@PathVariable int id) {
		return categoryService.deleteCategory(id);
	}
}