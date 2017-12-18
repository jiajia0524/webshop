package com.blue.fruits.entity;

import java.util.HashSet;
import java.util.Set;

public class Address {
	
	private int addressId;
	private int userId;
	private String addressName;
	private String addressTel;
	private String addressProvince;//省份
	private String addressCity;//市
	private String addressDistrict;//区
	private String addressDetail;
	private Set ordersSet = new HashSet<Orders>();
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getAddressTel() {
		return addressTel;
	}
	public void setAddressTel(String addressTel) {
		this.addressTel = addressTel;
	}
	public String getAddressProvince() {
		return addressProvince;
	}
	public void setAddressProvince(String addressProvince) {
		this.addressProvince = addressProvince;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getAddressDistrict() {
		return addressDistrict;
	}
	public void setAddressDistrict(String addressDistrict) {
		this.addressDistrict = addressDistrict;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public Set getOrdersSet() {
		return ordersSet;
	}
	public void setOrdersSet(Set ordersSet) {
		this.ordersSet = ordersSet;
	}
	
}
