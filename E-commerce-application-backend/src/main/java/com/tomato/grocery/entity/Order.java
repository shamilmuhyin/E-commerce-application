package com.tomato.grocery.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders") //class Order
public class Order {
	
	@Id @GeneratedValue
	private long orderId;
	private float orderAmount;
	private LocalDateTime orderDate;
	private int quantity;
	
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private AppUser appUser;
	@OneToOne
	@JoinColumn(name = "addressId")
	private Address address;
	@ManyToMany
	@JoinTable(name = "order_product",
			joinColumns = @JoinColumn(name = "orderId"),
			inverseJoinColumns = @JoinColumn(name = "productId"))
	@JoinColumn(name = "productId", referencedColumnName = "productId")
	private List<Product> products = new ArrayList<>();
	
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public AppUser getAppUser() {
		return appUser;
	}
	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
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
