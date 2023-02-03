package com.tomato.grocery.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomato.grocery.entity.Address;
import com.tomato.grocery.entity.AppUser;
import com.tomato.grocery.entity.Product;
import com.tomato.grocery.repository.AddressDAO;
import com.tomato.grocery.repository.ProductDAO;
import com.tomato.grocery.repository.UserDAO;
import com.tomato.grocery.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private AddressDAO addressDao;
	
	@Autowired
	private ProductDAO productDao;
	
	
	@Override
	public AppUser registerUser(AppUser userReq) {
		AppUser user = new AppUser();
		// if user already exist please return a string saying "user exist, please login"
		if(userDao.findByEmail(userReq.getEmail())!=null) {
			user = null;
		}
		else {
			List<Address> addresses = userReq.getAddresses();
			for(Address address: addresses) {
				addressDao.save(address);
			}
			user = userDao.save(userReq);
		}
		return user;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = productDao.findAll();
		return products;
	}
	
}
