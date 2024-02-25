package com.example.ecommerce.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Override
	public Product saveProduct(Product product) {
		Category c = product.getCategory();
		//check if category exists in DB
		if (c!=null) {
			Optional<Category> existingCategory = categoryService.getByCategoryName(c.getCategoryName());
			if (existingCategory.isPresent()) { 
				//in case only name is mentioned in JSON request 
				c.setId(existingCategory.get().getId());
				product.setCategory(c);
				return repository.save(product);
				}
			else 
				return null;	
		}	
		else 
			return repository.save(product);
	}
	
	@Override
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	@Override
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	@Override
	public Optional<Product> getProductById(Long id) {
		return repository.findById(id);
	}
	
	@Override
	public Optional<Product> getProductByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public String deleteProduct(Long id) {
		Optional<Product> optionalProduct = repository.findById(id);
		if ( optionalProduct.isPresent()) {
			repository.deleteById(id);
			return "Deleted product with ID:"+id;
		}
		else {
			return "Product with ID: "+id+" does not exist!!";
		}
	}
	
	@Override
	public String updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setImgUrl(product.getImgUrl());
		Category c = product.getCategory();
		if (c==null) {
			existingProduct.setCategory(c);
			repository.save(existingProduct);
			return "Product updated ! ";
		}
		else {
			Optional<Category> existingCategory = categoryService.getByCategoryName(c.getCategoryName());
			if (existingCategory.isPresent()) { 
				c.setId(existingCategory.get().getId());
				existingProduct.setCategory(c);
				repository.save(existingProduct);
				return "Product updated ! ";
				}
			else 
				return "Category not found";	
		}	
	}
}
