package com.blue.fruits.cart.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blue.fruits.cart.dao.CartDaoImpl;
import com.blue.fruits.entity.Cart;
import com.blue.fruits.entity.Fruits;
import com.blue.fruits.entity.Orders;
import com.blue.fruits.entity.User;

@Service
public class CartServiceImpl {
	
	@Resource
	private CartDaoImpl cartDaoImpl;
	
	public List<Cart> selectAll(){
	List<Cart> list = cartDaoImpl.selectAll();
	return list;
    }
    public List<Cart> selectByUserId(int userId){
	List<Cart> list = cartDaoImpl.selectByUserId(userId);
	return list;
    }

	public List<Cart> selectById(String[] c){
		List<Cart> list = cartDaoImpl.selectById(c);
		return list;
	}
	public void addCart(int userId,int fruits_id ) {
		cartDaoImpl.addCart(userId, fruits_id);
	}
	public void deleteCart(int cartId) {
		cartDaoImpl.deleteCart(cartId);
	}
	
	public User addCount(int id) {
		User user = cartDaoImpl.addCount(id);
		return user;
	}
	
	public void misCount(int id) {
		cartDaoImpl.misCount(id);
	}
	public CartDaoImpl getCartDao() {
		return cartDaoImpl;
	}
	public void setCartDao(CartDaoImpl cartDaoImpl) {
		this.cartDaoImpl = cartDaoImpl;
	}

}

//public boolean addFruits(int userId, int fruits_id, int num, int fruits_presentprice, Date now) {
//	boolean flag=cartDaoImpl.addFruits(userId,fruits_id,num,fruits_presentprice,now); 
//	return flag; 
//}
//
//public List<Orders> findCart(int userId) {
//	List<Orders> list=cartDaoImpl.findCart(userId);
//	return list;
//}
//
//public Fruits findfruitsById(int id) {
//	Fruits fruits=cartDaoImpl.findfruitsById(id);
//	return fruits;
//}
//public User findUser(String userName) {
//	User user=cartDaoImpl.findUser(userName);
//	return user;
//}
//public boolean deleteFruits(int userId,int id) {
//	boolean flag=cartDaoImpl.deleteFruits(userId,id);
//	return flag;
//}
//public boolean downFruits(int userId, int id) {
//	boolean flag=cartDaoImpl.downFruits(userId,id);
//	return flag;
//}
