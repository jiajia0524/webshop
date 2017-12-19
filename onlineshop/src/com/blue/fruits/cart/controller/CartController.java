package com.blue.fruits.cart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blue.fruits.cart.service.CartServiceImpl;
import com.blue.fruits.entity.Cart;
import com.blue.fruits.entity.Fruits;
import com.blue.fruits.entity.Orders;
import com.blue.fruits.entity.User;

@Controller
@RequestMapping("cart")
public class CartController {
	
	@Resource
	private CartServiceImpl cartServiceImpl;
	
	@RequestMapping("/cartlist")
	public String selectAll(Model model) {
		List<Cart> list = cartServiceImpl.selectAll();
		model.addAttribute("cartlist",list);
		return "cart/cart";
	}
	//后台购物车列表
	@RequestMapping("/cartlist1")
	public String selectAll1(Model model) {
		List<Cart> list = cartServiceImpl.selectAll();
		model.addAttribute("cartlist",list);
		return "backstage/cartlist";
	}
	
	@RequestMapping("/usershopping")
	public String selectByUserId(Model model,int userId) {
		List<Cart> list = cartServiceImpl.selectByUserId(userId);
		model.addAttribute("usershopping",list);
		return "user/user_shopping";
	}
	
	@RequestMapping("/addcart")
	public String addCart(int userId,int fruits_id) {
		System.out.println(fruits_id);
		cartServiceImpl.addCart(userId, fruits_id);
		return "front/fruitsDetail";
	}
	
	@RequestMapping("carttoorders")
	public String toOrdersFruits(Model model,HttpServletRequest request) {
		String[] c = request.getParameterValues("cart");
		List<Cart> list = cartServiceImpl.selectById(c);
		int sum = 0;
		for(int i = 0; i < list.size(); i ++) {
			sum+= list.get(i).getFruits().getFruits_presentprice() * list.get(i).getCount();
		}
		model.addAttribute("toorders", list);
		model.addAttribute("sum", sum);
		return "order/user_toorders";
	}
	
	@RequestMapping("/deletecart")
	public String deleteFruits(int cartId) {
		System.out.println("delete");
		cartServiceImpl.deleteCart(cartId);
		return "redirect:cart";
	}
	
	@RequestMapping("/addcount")
	public String addCount(int id,HttpServletRequest request) {
		User user = cartServiceImpl.addCount(id);
		HttpSession session = request.getSession();
		session.setAttribute("login_user",user);
		return "user/main";
	}
	
	@RequestMapping("/miscount")
	public String misCount(int id) {
		cartServiceImpl.misCount(id);
		return "user/user_shopping";
	}
	
	public CartServiceImpl getCartServiceImpl() {
		return cartServiceImpl;
	}

	public void setCartServiceImpl(CartServiceImpl cartServiceImpl) {
		this.cartServiceImpl = cartServiceImpl;
	}

}


