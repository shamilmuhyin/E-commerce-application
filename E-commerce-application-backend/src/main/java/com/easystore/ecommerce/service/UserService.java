package com.easystore.ecommerce.service;

import java.util.List;

import com.easystore.ecommerce.entity.Role;
import com.easystore.ecommerce.entity.User;

public interface UserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User> getUsers();
}
