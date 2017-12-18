package com.blue.fruits.address.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blue.fruits.address.dao.AddressDaoImpl;
import com.blue.fruits.entity.Address;


@Service
public class AddressServiceImpl {
	
	@Resource AddressDaoImpl addressDaoImpl;
	
	public Boolean addAddress(Address address) {
		Boolean b = addressDaoImpl.addAddress(address);
		return b;
	}
	public List<Address> selectAll(){
		List<Address> list = addressDaoImpl.selectAll();
		return list;
	}
	public Address selectById(int id) {
		Address address = addressDaoImpl.selectById(id);
		return address;
	}
	public List<Address> selectByUserId(int userId){
		List<Address> list = addressDaoImpl.selectByUserId(userId);
		return list;
	}
	public int updateAddress(Address address) {
		int i = addressDaoImpl.updateAddress(address);
		return i;
	}
	public void deleteAddress(int id) {
		addressDaoImpl.deleteAddress(id);
	}

}
