package com.example.demo.Configuration;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.userRepository;

@Service
public class CustomUserDetails implements UserDetailsService{
	
	@Autowired
	userRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= repo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not exists"));
		
		return new org.springframework.security.core.userdetails.User(
				username, 
				user.getPassword(), 
				Arrays.asList(new SimpleGrantedAuthority("USER")));
	}

}
