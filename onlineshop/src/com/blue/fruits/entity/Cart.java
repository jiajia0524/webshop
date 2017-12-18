package com.blue.fruits.entity;

public class Cart {
	
	private int cartId;
	private int count;
	private User user;
	private Fruits fruits;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Fruits getFruits() {
		return fruits;
	}
	public void setFruits(Fruits fruits) {
		this.fruits = fruits;
	}
	
	

	
	
}
