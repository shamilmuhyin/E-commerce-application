package com.tomato.grocery.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomato.grocery.entity.AppUser;
import com.tomato.grocery.entity.Order;
import com.tomato.grocery.entity.Product;
import com.tomato.grocery.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(path = "/registerUser")
	public AppUser RegisterUser(@RequestBody AppUser userReq) {
		AppUser user = new AppUser();
		userReq.setRegistrationDate(LocalDateTime.now());
		user = customerService.registerUser(userReq);
		return user;
	}
	
	@GetMapping(path = "/browseProducts")
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>(); 
		products = customerService.getAllProducts();
		return products;
	}
	
	@PostMapping(path = "/createOrder")
	public Order createOrder(@RequestBody Order orderReq) {
		Order order = new Order();
		customerService.createOrder(orderReq);
		return order;
	}
}
