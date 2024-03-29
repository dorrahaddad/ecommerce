package com.example.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController{

	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product){
		return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products){
		return service.saveProducts(products);
	}
	
	@GetMapping
	public List<Product> findAllProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/productById/{id}")
	public Optional<Product> findProductById(@PathVariable Long id){
		return service.getProductById(id);
	}
	
	@GetMapping("/product/{name}")
	public Optional<Product> findProductByName(@PathVariable String name){
		return service.getProductByName(name);
	}
	
	@PutMapping("/update")
	public String updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		return service.deleteProduct(id);
	}
	 @GetMapping("/advanced-search")
	    public List<Product> advancedSearch(
	            @RequestParam(required = false) String name,
	            @RequestParam(required = false) String description,
	            @RequestParam(required = false) Integer quantity,
	            @RequestParam(required = false) Double price,
	            @RequestParam(required = false) String imgUrl,
	            @RequestParam(required = false) String categoryName
	    ) {
	        return service.performAdvancedSearch(name, description, quantity, price, imgUrl, categoryName);
	      }
	 @GetMapping("/searchWithPriceRange")
	    public List<Product> getProductsInPriceRange(
	            @RequestParam(name = "minPrice") double minPrice,
	            @RequestParam(name = "maxPrice") double maxPrice) {

	        return service.getProductsInPriceRange(minPrice, maxPrice);
	    }

}