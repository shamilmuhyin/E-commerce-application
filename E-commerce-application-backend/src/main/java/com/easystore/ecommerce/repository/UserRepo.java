package com.easystore.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easystore.ecommerce.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
	User findByUsername(String Username);
}
