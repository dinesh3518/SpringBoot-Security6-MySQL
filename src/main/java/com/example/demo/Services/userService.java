package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Dto.userDto;
import com.example.demo.Entity.User;
import com.example.demo.Repository.userRepository;

@Service
public class userService {
	
	@Autowired
	private userRepository repo;
	
	@Autowired
	PasswordEncoder Encoder;
	
	public String saveUser(userDto dto) {
		
		User user= new User();
		user.setEmail(dto.getEmail());
		user.setName(dto.getName());
		user.setPassword(Encoder.encode(dto.getPassword()));
		repo.save(user);
		return "Registration Success!!";
	}
	
	public boolean hasUserName(String userName) {
		
		return repo.existsByEmail(userName);
	}

}
