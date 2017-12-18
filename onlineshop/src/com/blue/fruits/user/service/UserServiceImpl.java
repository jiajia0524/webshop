package com.blue.fruits.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.blue.fruits.entity.User;
import com.blue.fruits.user.dao.UserDaoImpl;



@Service
@Transactional(readOnly=true)
public class UserServiceImpl {
	
	@Resource
	private UserDaoImpl userDaoImpl;
	
	public User login(String name, String password){
		User lu=this.userDaoImpl.findById(name);
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
	
	public List<User> selectAll() {
		List<User> list = userDaoImpl.selectAll();
		return list;
	}
	
	public List<String> selectAllName() {
		return userDaoImpl.selectAllName();
		
	}
	
	public Boolean add(User user) {
		return userDaoImpl.add(user);
		
	}
	
	public User selectById(int id) {
		User user = userDaoImpl.selectById(id);
		return user;
	}
	
	public int updateUser(User user) {
		int i = userDaoImpl.updateUser(user);
		return i;
	}
	
	public void deleteUser(int userId) {
		userDaoImpl.deleteUser(userId);
	}
	
	public void userImg(String realPath, MultipartFile file, int id) {
		userDaoImpl.userImg(realPath, file, id);
	}
	

}
