package com.blue.fruits.admin.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blue.fruits.admin.dao.AdminDaoImpl;
import com.blue.fruits.entity.User;

@Service
@Transactional(readOnly=true)
public class AdminServiceImpl {
	
	@Resource
	private AdminDaoImpl adminDaoImpl;
	
	public User login(String name, String password){
		User lu=this.adminDaoImpl.findById(name);
		if(lu!=null){
			if(lu.getUserPassword().equals(password)){
				return lu;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

}
