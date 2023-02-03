package com.tomato.grocery.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomato.grocery.entity.Address;
import com.tomato.grocery.entity.AppUser;
import com.tomato.grocery.repository.AddressDAO;
import com.tomato.grocery.repository.UserDAO;
import com.tomato.grocery.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private AddressDAO addressDao;
	
	@Override
	public AppUser registerUser(AppUser userReq) {
		List<Address> addresses = userReq.getAddresses();
		for(Address address: addresses) {
			addressDao.save(address);
		}
		return userDao.save(userReq);
	}
	
}
