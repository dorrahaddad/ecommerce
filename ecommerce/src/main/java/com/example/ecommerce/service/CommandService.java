package com.example.ecommerce.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Command;
import com.example.ecommerce.model.CommandLine;
import com.example.ecommerce.model.Product;
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
	 @Autowired
	 private CommandLineService cmdLineServ;
	 

	  
	    public CommandService(CommandRepository cmdRepository, CommandLineRepository cmdLineRepository) {
		super();
		this.cmdRepository = cmdRepository;
		this.cmdLineRepository = cmdLineRepository;
	}

		public Command saveCmd(Command command){
			Date aujourdhui = new Date();
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			String dateFormatee = formater.format(aujourdhui);
			Date date;
			try {
				date = formater.parse(dateFormatee);
				command.setDate(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			/*double total = 0.0 ;
			for(CommandLine cmdLine : cmd.getCommandLines()) {
				total += cmdLine.getPrix();
			}
			command.setPrixCmd(total);*/
	       return cmdRepository.save(command);
	    }
	
		public Optional<Command> getCommandById(Long id) {
			return cmdRepository.findById(id);
		}
		
		public double findCmdLines(Long id) {
			double somme = 0.0;
			
			for(CommandLine cmdLine : cmdLineServ.getCommandLines()) {
				if (cmdLine.getCommand().getId()== id) {
					somme+= cmdLine.getPrix();
				}
			}
			return somme;
		}
		public String deleteCommand(Long id) {
			Optional<Command> optionalCommand = cmdRepository.findById(id);
			if ( optionalCommand.isPresent()) {
				cmdRepository.deleteById(id);
				return "Deleted command with ID:"+id;
			}
			else {
				return "Command with ID: "+id+" does not exist!!";
			}
		}
		
		
//		public String updateCommand(Command command) {
//			Command existingCommand = cmdRepository.findById(command.getId()).orElse(null);
//			existingCommand.setName(command.getName());
//			existingCommand.setDescription(command.getDescription());
//			existingCommand.setQuantity(command.getQuantity());
//			existingCommand.setPrice(command.getPrice());
//			existingCommand.setImgUrl(command.getImgUrl());
//			Category c = command.getCategory();
//			if (c==null) {
//				existingCommand.setCategory(c);
//				cmdRepository.save(existingProduct);
//				return "Product updated ! ";
//			}
//			else {
//				Optional<Category> existingCategory = categoryService.getByCategoryName(c.getCategoryName());
//				if (existingCategory.isPresent()) { 
//					c.setId(existingCategory.get().getId());
//					existingProduct.setCategory(c);
//					cmdRepository.save(existingProduct);
//					return "Product updated ! ";
//					}
//				else 
//					return "Category not found";	
//			}	
//		}

}
