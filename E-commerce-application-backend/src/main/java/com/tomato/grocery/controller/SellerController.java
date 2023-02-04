package com.tomato.grocery.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tomato.grocery.entity.Product;
import com.tomato.grocery.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@PostMapping(path = "/updateProduct")
	public Product createOrUpdateProduct(@RequestBody Product productReq) {
		Product product = new Product();
		productReq.setUpdateDate(LocalDateTime.now());
		product = sellerService.createOrUpdateProduct(productReq);
		return product;
	}
	
	@PutMapping("updateProduct/{id}")
	public Optional<Product> updateProduct(@PathVariable long id, @RequestParam(value = "stock") float stock) {
		Optional<Product> product = Optional.ofNullable(new Product());
		product = sellerService.updateProduct(id, stock);
		return product;
	}
	
	
}
