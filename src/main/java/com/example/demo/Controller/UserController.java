package com.example.demo.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.userDto;
import com.example.demo.Services.userService;

@RestController
@RequestMapping
public class UserController {
	
	@Autowired
	private userService service;
	
	
	@PostMapping("/reg")
	public String signUp(@Validated @RequestBody userDto user) {
		
	
		
		if(service.hasUserName(user.getEmail()))
			return "Email already exists";
		
		return service.saveUser(user);
	}
	
	@GetMapping("/user")
	public String hello() {
		return "Hello User";
	}
	@GetMapping("/admin")
	public String hello2() {
		return "Hello Admin";
	}

}
