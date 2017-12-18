package com.blue.fruits.address.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blue.fruits.address.service.AddressServiceImpl;
import com.blue.fruits.entity.Address;


@Controller
@RequestMapping("address")
public class AddressController {
	
	@Resource
	private AddressServiceImpl addressServiceImpl;
	
	@RequestMapping("/addaddress")
	public String addAddress(Address address) {
		Boolean b = addressServiceImpl.addAddress(address);
		if(b != false) {
			return "succeed";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/addresslist")
	public String selectAll(Model model){
		List<Address> list = addressServiceImpl.selectAll();
		model.addAttribute("addresslist", list);
		return "user/address_list";
	}
	
	@RequestMapping("/addressdetail")
	public String selectById(Model model,int id) {
		Address address = addressServiceImpl.selectById(id);
		model.addAttribute("address",address);
		return "user/address_update";
	}
	
	@RequestMapping("/useraddress")
	public String selectByUserId(Model model,int userId) {
		List<Address> list = addressServiceImpl.selectByUserId(userId);
		model.addAttribute("useraddress", list);
		return "user/user_address";
	}
	
	@RequestMapping("/updateaddress")
	public String updateAddress(Address address) {
		int i = addressServiceImpl.updateAddress(address);
		if(i > 0) {
			return "succeed";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/deleteaddress")
	public String deleteAddress(int id) {
		addressServiceImpl.deleteAddress(id);
		return "succeed";
	}

}
