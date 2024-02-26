package com.example.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Command;
import com.example.ecommerce.model.CommandLine;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.CommandLineRepository;
import com.example.ecommerce.repository.CommandRepository;
import com.example.ecommerce.repository.UserRepository;
@Service
public class CommandService {
	 @Autowired
	 private CommandRepository cmdRepository;
	 @Autowired
	 private CommandLineRepository cmdLineRepository;
	 

	  
	    public CommandService(CommandRepository cmdRepository, CommandLineRepository cmdLineRepository) {
		super();
		this.cmdRepository = cmdRepository;
		this.cmdLineRepository = cmdLineRepository;
	}

		public Command saveCmd(Command command) {
	        return cmdRepository.save(command);
	    }
	
	  

}
