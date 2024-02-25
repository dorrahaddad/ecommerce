package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UserController {
	@Autowired
	private UserService userService;

    @GetMapping("/")
	public List<User> showUsers(){
		return userService.getUsers();
	}
	
	@PostMapping("/addUser")
	public User addUsers(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/getUser/{id}")
	public User findUser(@PathVariable Long id) {
		return userService.findUser(id);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}
	   @GetMapping("/byEmail")
	    public Optional getUserByEmail(@RequestParam String email) {
	        return userService.findByEmail(email);
	    }
	    @GetMapping("/search")
	    public List<User> rechercheAvancee(
	            @RequestParam(required = false) String nom,
	            @RequestParam(required = false) String prenom,
	            @RequestParam(required = false) String adresse,
	            @RequestParam(required = false) Long telephone
	    ) {
	        return userService.rechercheAvancee(nom, prenom, adresse, telephone);
	    }


}