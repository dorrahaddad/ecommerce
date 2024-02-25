package com.example.ecommerce.service;

import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.model.Category;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
    	Optional<Category> optionalCategory = categoryRepository.findByCategoryName(category.getCategoryName());
    	if ( optionalCategory.isPresent()) {
    		return null;
    	}
        else { 
        	return categoryRepository.save(category);
        	}
    }
    
    @Override
	public List<Category> saveCategories(List<Category> categories) {
		return categoryRepository.saveAll(categories);
	}

    @Override
    public Optional<Category> getByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }
    
    @Override
	public Optional<Category> getByCategoryId(int id) {
		return categoryRepository.findById(id);
	}
    
    @Override
	public String deleteCategory(int id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if ( optionalCategory.isPresent()) {
			categoryRepository.deleteById(id);
			return "Deleted category with ID:"+id;
		}
		else {
			return "category with ID: "+id+" does not exist!!";
		}
	}
	
	@Override
	public Category updateCategory(Category category) {
		Category existingCategory = categoryRepository.findById(category.getId()).orElse(null);
		existingCategory.setCategoryName(category.getCategoryName());
		existingCategory.setProducts(category.getProducts());
		return categoryRepository.save(existingCategory);
	}

}