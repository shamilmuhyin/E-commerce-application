package com.tomato.grocery.service;

import java.util.List;

import com.tomato.grocery.entity.AppUser;
import com.tomato.grocery.entity.Order;
import com.tomato.grocery.entity.Product;

public interface CustomerService {
	public AppUser registerUser(AppUser userReq);
	public List<Product> getAllProducts();
	public Order createOrder(Order orderReq);
}
