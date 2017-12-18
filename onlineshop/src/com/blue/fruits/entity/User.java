package com.blue.fruits.entity;

import java.util.HashSet;
import java.util.Set;

//@Entity
//@Table(name="user")
public class User {
	
	private int userId;
	private String userName;
	private String userPassword;
	private String userImage;
	private String userEmail;
	private Set<Address> addressSet = new HashSet<Address>();
	private Set<Cart> cartSet = new HashSet<Cart>();
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Set<Address> getAddressSet() {
		return addressSet;
	}
	public void setAddressSet(Set<Address> addressSet) {
		this.addressSet = addressSet;
	}
	public Set<Cart> getCartSet() {
		return cartSet;
	}
	public void setCartSet(Set<Cart> cartSet) {
		this.cartSet = cartSet;
	}
	public Set<Orders> getOrdersSet() {
		return ordersSet;
	}
	public void setOrdersSet(Set<Orders> ordersSet) {
		this.ordersSet = ordersSet;
	}
	private Set<Orders> ordersSet = new HashSet<Orders>();
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)

	
	
}
