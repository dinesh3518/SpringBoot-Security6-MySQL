package com.example.demo.Repository;

import com.example.demo.Entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface userRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);

}
