package com.example.ecommerce.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Override
	public Product saveProduct(Product product) {
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
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	@Override
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}
	
	@Override
	public String deleteProduct(int id) {
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
	public Product updateProduct(Product product) {
		Product existingProduct = repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}
}
