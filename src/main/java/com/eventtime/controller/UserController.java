package com.eventtime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eventtime.bean.User;
import com.eventtime.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	

	@GetMapping(path= "/user/{id}")
	public User getEventById (@PathVariable String username) {
		return userService.getUserByUsername(username);
	}
	
	@PostMapping(path="/user")
	public ResponseEntity<HttpStatus> addEvent (@RequestBody User user){
		userService.createUser(user);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}
	
	@PutMapping(path="/user")
	public ResponseEntity<HttpStatus> updateEvent (@RequestBody User user){
		userService.updateUser(user);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path="/user")
	public ResponseEntity<HttpStatus> deleteEvent (@RequestBody User user) {
		userService.deleteUser(user);;
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
