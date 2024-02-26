package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.CommandLine;

@Repository
public interface CommandLineRepository extends JpaRepository<CommandLine, Long>{

}
