package com.tomato.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomato.grocery.entity.AppUser;

public interface UserDAO extends JpaRepository<AppUser, Long>{
	
	AppUser findByEmail(String email);
	
}
