package com.userDepartament.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public User findById(@PathVariable Long id) {
		User user = repository.findById(id).get();
		return user;
	}
	
	@PostMapping
	public void insert(@RequestBody User user) {
		repository.save(user);
	}
}
