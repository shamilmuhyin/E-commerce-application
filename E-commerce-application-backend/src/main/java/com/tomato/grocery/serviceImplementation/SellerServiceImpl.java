package com.tomato.grocery.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomato.grocery.entity.Product;
import com.tomato.grocery.repository.ProductDAO;
import com.tomato.grocery.service.SellerService;

@Service
public class SellerServiceImpl implements SellerService{

	@Autowired
	private ProductDAO productDao;
	
	@Override
	public Product updateProduct(Product productReq) {
		Product product = productDao.save(productReq);
		return product;
	}

}
