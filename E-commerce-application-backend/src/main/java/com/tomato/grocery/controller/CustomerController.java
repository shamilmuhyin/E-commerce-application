package com.tomato.grocery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tomato.grocery.entity.AppUser;
import com.tomato.grocery.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping(path = "/registerUser")
	public AppUser RegisterUser(@RequestBody AppUser userReq) {
		return customerService.registerUser(userReq);
	}
}
