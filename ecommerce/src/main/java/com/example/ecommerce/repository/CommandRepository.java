package com.example.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Command;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long>{
	
}
