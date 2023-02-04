package com.tomato.grocery.service;

import java.util.Optional;

import com.tomato.grocery.entity.Product;

public interface SellerService {
	public Product createOrUpdateProduct(Product productReq);
	//public Optional<Product> updateProduct(long id);
	public Optional<Product> updateProduct(long id, float stock);
}
