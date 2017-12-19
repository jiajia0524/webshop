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

