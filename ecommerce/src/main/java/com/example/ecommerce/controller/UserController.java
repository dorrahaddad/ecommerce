package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
import java.util.List;

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


}