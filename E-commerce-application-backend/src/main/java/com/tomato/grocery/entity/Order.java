package com.tomato.grocery.entity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyJoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders") //class Order
public class Order {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	private float orderAmount;
	private LocalDateTime orderDate;
	private int quantity;
	
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private AppUser user;
	@OneToOne
	@JoinColumn(name = "addressId")
	private Address address;
	@ElementCollection
	@JoinTable(name = "order_product",
			joinColumns = @JoinColumn(name = "orderId"))
	@MapKeyJoinColumn(name = "product_id")
	private Map<Long, Integer> productMap = new HashMap<>();
	
	
	public AppUser getUser() {
		return user;
	}
	public void setUser(AppUser user) {
		this.user = user;
	}
	public Map<Long, Integer> getProductMap() {
		return productMap;
	}
	public void setProductMap(Map<Long, Integer> productMap) {
		this.productMap = productMap;
	}
	public AppUser getAppUser() {
		return user;
	}
	public void setAppUser(AppUser appUser) {
		this.user = appUser;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public float getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(float orderAmount) {
		this.orderAmount = orderAmount;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	
}
