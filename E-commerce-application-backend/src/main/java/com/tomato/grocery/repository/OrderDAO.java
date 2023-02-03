package com.tomato.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tomato.grocery.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Long>{

}
