package com.example.ecommerce.controller;

import java.util.ArrayList;
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

import com.example.ecommerce.model.Command;
import com.example.ecommerce.model.CommandLine;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.service.CommandLineService;
import com.example.ecommerce.service.CommandService;
import com.example.ecommerce.service.UserService;

@RestController
@RequestMapping("/commands")
public class CommandController {
	@Autowired
	private CommandService commandService;
	@Autowired
	private CommandLineService cmdLineService;

 
	
	@PostMapping("/addCommand")
	public String addCommand(@RequestBody Command command) {
		commandService.saveCmd(command);
		double somme=0.0;
		for (CommandLine cmdLine : command.getCommandLines()) {
			cmdLine.setCommand(command);
			cmdLineService.saveCmdLine(cmdLine);
			somme+=cmdLine.getPrix();
			
		}
		System.out.println("testttt"+ somme);
		command.setPrixCmd(somme);
		commandService.saveCmd(command);
		
		return "command added successufully!";
	}
	@GetMapping("/commandById/{id}")
	public Optional<Command> findCommandById(@PathVariable Long id){
		return commandService.getCommandById(id);
	}
	
	
		

}
