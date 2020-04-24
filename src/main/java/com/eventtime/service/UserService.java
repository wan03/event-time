package com.eventtime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventtime.bean.User;
import com.eventtime.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	@Autowired 
	private void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	public User getUserByUsername(String username) {
		return userRepository.getOne(username);
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser (User user) {
		userRepository.delete(user);
	}

}
