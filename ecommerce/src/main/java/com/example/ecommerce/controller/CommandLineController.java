package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.CommandLine;
import com.example.ecommerce.model.Product;

import com.example.ecommerce.service.CommandLineService;

@RestController
@RequestMapping("/commandLine")
public class CommandLineController {
	
	
	@Autowired
	private CommandLineService service;
	
	
	@GetMapping
	public List<CommandLine> findAllCommandLines(){
		return service.getCommandLines();
	}

}
