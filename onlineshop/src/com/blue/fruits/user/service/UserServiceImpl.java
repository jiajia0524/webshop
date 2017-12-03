package com.blue.fruits.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blue.fruits.entity.User;
import com.blue.fruits.user.dao.UserDaoImpl;



@Service
@Transactional(readOnly=true)
public class UserServiceImpl {
	
	@Resource
	private UserDaoImpl loginUserDaoImpl;
	
	public User login(String name, String password){
		User lu=this.loginUserDaoImpl.findById(name);
		if(lu!=null){
			if(lu.getUser_password().equals(password)){
				return lu;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

}
