package com.tomato.grocery.serviceImplementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tomato.grocery.entity.Address;
import com.tomato.grocery.entity.AppUser;
import com.tomato.grocery.entity.Order;
import com.tomato.grocery.entity.Product;
import com.tomato.grocery.repository.AddressDAO;
import com.tomato.grocery.repository.OrderDAO;
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
	
	@Autowired
	private OrderDAO orderDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public AppUser registerUser(AppUser userReq) {
		AppUser user = new AppUser();
		// encrypt the password
		userReq.setPassword(passwordEncoder.encode(userReq.getPassword()));
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
		List<Product> products = new ArrayList<>();
		products = productDao.findAll();
		return products;
	}

	@Override
	public Order createOrder(Order orderReq) {
		Order order = new Order();
		Address address = new Address();
		address = addressDao.findById(orderReq.getAddress().getAddressId()).get();
		orderReq.setAddress(address);
		AppUser user = new AppUser();
		user = userDao.findById(orderReq.getAppUser().getUserId()).get();
		orderReq.setAppUser(user);
		Map<Long, Integer> productMap = new HashMap<>();
		productMap = orderReq.getProductMap();
		//update stock according to order quantity
		// update total order amount
		float totalAmount = 0;
		int quantity = 0;
		for(Map.Entry<Long, Integer> entry: productMap.entrySet()) {
			Product product = new Product();
			product = productDao.findById(entry.getKey()).get();
			float stock = product.getStock()-entry.getValue();
			product.setStock(stock);
			productDao.save(product);
			totalAmount = product.getPrice()*entry.getValue()+totalAmount;
			quantity = quantity + entry.getValue();
		}
		orderReq.setOrderDate(LocalDateTime.now());
		orderReq.setOrderAmount(totalAmount);
		orderReq.setQuantity(quantity);
		order = orderDao.save(orderReq);
		return order;
	}
	
}
