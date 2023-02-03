package com.tomato.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomato.grocery.entity.Address;

public interface AddressDAO extends JpaRepository<Address, Long>{

}
