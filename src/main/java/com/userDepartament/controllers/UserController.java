package com.userDepartament.controllers;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.userDepartament.entities.User;
import com.userDepartament.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public List<User> findAll() {
		List<User> users = repository.findAll();
		return users;
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public User findById(@PathVariable Long id) {
		User user = repository.findById(id).get();
		return user;
	}
	
	@PostMapping
	public String insert(@RequestBody User user) {
		repository.save(user);
		JSONObject json = new JSONObject();
		json.put("status", 201);
		json.put("message", "User created successfully!");
		return json.toString();
	}
	
	@DeleteMapping(value = "/{id}")
	public String deleteById(@PathVariable("id") Long id) {
		User user = repository.findById(id).get();
		
		JSONObject json = new JSONObject();
		if(user == null) {
			json.put("status", 401);
			json.put("message", "user not found!");
			return json.toString();
		}

		repository.deleteById(id);
		json.put("status", 200);
		json.put("message", "User successfully deleted!");
		return json.toString();
		
	}
}
