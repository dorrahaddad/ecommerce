package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Command;
import com.example.ecommerce.model.CommandLine;
import com.example.ecommerce.repository.CommandLineRepository;
import com.example.ecommerce.repository.CommandRepository;
import com.example.ecommerce.repository.ProductRepository;
@Service
public class CommandLineService {
	 @Autowired
	 private ProductRepository productRepository;
	 @Autowired
	 private CommandLineRepository cmdLineRepository;
	 

	  
	  

		public CommandLineService(ProductRepository productRepository, CommandLineRepository cmdLineRepository) {
		super();
		this.productRepository = productRepository;
		this.cmdLineRepository = cmdLineRepository;
	}


		public CommandLine saveCmdLine(CommandLine commandLine) {
	        return cmdLineRepository.save(commandLine);
	    }
}
