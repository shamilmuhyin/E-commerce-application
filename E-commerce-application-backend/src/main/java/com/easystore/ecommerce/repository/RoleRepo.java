package com.easystore.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easystore.ecommerce.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long>{
	Role findByName(String name);
}
