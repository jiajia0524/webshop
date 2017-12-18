package com.blue.fruits.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class Orders {
	
	private int orderId;
	private int userId;
	private int price;
	private int count;
	private String time;
	private int orderState;
	private Address address;
	private Set<Fruits> fruitsSet = new HashSet<>();
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Fruits> getFruitsSet() {
		return fruitsSet;
	}
	public void setFruitsSet(Set<Fruits> fruitsSet) {
		this.fruitsSet = fruitsSet;
	}
	
}
