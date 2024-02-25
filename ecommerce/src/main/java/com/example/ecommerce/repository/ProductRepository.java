package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByName(String name);
}
