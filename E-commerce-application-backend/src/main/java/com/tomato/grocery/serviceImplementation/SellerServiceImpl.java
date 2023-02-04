package com.tomato.grocery.serviceImplementation;

import java.util.Optional;

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
	public Product createOrUpdateProduct(Product productReq) {
		Product product = new Product();
		// if product already exist update stock only
		product = productDao.findByProductName(productReq.getProductName());
		if(product!= null) {
			product.setStock(product.getStock()+ productReq.getStock());
			product = productDao.save(product);
		}
		else {
			product = productDao.save(productReq);
		}
		return product;
	}

	@Override
	public Optional<Product> updateProduct(long id,float stock) {
		Optional<Product> product = Optional.ofNullable(new Product());
		product = productDao.findById(id);
		if(product != null) {
			stock = product.get().getStock() + stock;
			product.get().setStock(stock);
			product = Optional.of(productDao.save(product.get()));
		}
		return product;
	}

}
