package com.tomato.grocery.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tomato.grocery.entity.Product;
import com.tomato.grocery.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@PostMapping(path = "/updateProduct")
	public Product updateProduct(@RequestBody Product productReq) {
		Product product = new Product();
		productReq.setUpdateDate(LocalDateTime.now());
		product = sellerService.updateProduct(productReq);
		return product;
	}
}
