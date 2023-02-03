package com.tomato.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomato.grocery.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Long>{

}
