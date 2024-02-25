package com.example.ecommerce.service;

import java.util.List;
import java.util.Optional;
import com.example.ecommerce.model.Product;

public interface ProductService {

	public Product saveProduct(Product product);
	public List<Product> saveProducts(List<Product> products);
	public List<Product> getProducts();
	public Optional<Product> getProductById(Long id);
	public Optional<Product> getProductByName(String name);
	public String deleteProduct(Long id);
	public String updateProduct(Product product);
}

