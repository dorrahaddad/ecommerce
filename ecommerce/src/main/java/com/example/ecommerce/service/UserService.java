package com.example.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public User findUser(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public String deleteUser(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if ( optionalUser.isPresent()) {
			userRepository.deleteById(id);
			return "Deleted user with ID:"+id;
		}
		else {
			return "User with ID: "+id+" does not exist!!";
		}
	}
	
	public User updateUser(User user) {
		User existuser = userRepository.findById(user.getId()).orElse(null);
		existuser.setAdresse(user.getAdresse());
		existuser.setEmail(user.getEmail());
		existuser.setPassword(user.getPassword());
		existuser.setNom(user.getNom());
		existuser.setPrenom(user.getPrenom());
		existuser.setTelephone(user.getTelephone());
		existuser.setRole(user.getRole());
		return userRepository.save(existuser);
	}
	 public List<User> rechercheAvancee(String nom, String prenom, String adresse, Long telephone) {
	        return userRepository.rechercheAvancee(nom, prenom, adresse, telephone);
	    }
}