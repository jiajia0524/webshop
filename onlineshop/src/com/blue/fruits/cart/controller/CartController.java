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



//
//import com.blue.fruits.cart.service.CartServiceImpl;
//import com.blue.fruits.entity.Cart;
//import com.blue.fruits.entity.User;
//
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



//@RequestMapping("/joininshoppingcart")
//public  String joininshoppingcart(Model model ,HttpServletRequest request,int id) {
//	
//	String num=request.getParameter("number");
//	
//	 Date now = new Date();
//      Calendar cal = Calendar.getInstance();
//     
//      DateFormat d1 = DateFormat.getDateInstance(); 
//      String str1 = d1.format(now);
//      DateFormat d2 = DateFormat.getDateTimeInstance();
//      String str2 = d2.format(now);
//      DateFormat d3 = DateFormat.getTimeInstance();
//      String str3 = d3.format(now);
//      DateFormat d4 = DateFormat.getInstance(); //使用SHORT风格显示日期和时间
//      String str4 = d4.format(now);
//      DateFormat d5 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); //显示日期，周，时间（精确到秒）
//      String str5 = d5.format(now);
//      DateFormat d6 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG); //显示日期。时间（精确到秒）
//      String str6 = d6.format(now);
//      DateFormat d7 = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT); //显示日期，时间（精确到分）
//      String str7 = d7.format(now);
//      DateFormat d8 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM); //显示日期，时间（精确到分）
//      String str8 = d8.format(now);//与SHORT风格相比，这种方式最好用
//	HttpSession session=request.getSession();
//	
//	String userName=(String)session.getAttribute("userName");
//	User user=cartServiceImpl.findUser(userName);
//	int userId=user.getUserId();
//	System.out.println("111111");
//	Fruits fruits=cartServiceImpl.findfruitsById(id);
//	int fruits_presentprice=(int) fruits.getFruits_presentprice();
//	int num1=Integer.parseInt(num);
//	
//	boolean flag=cartServiceImpl.addFruits(userId,id,num1,fruits_presentprice,now);
//	if(flag==true) { 
//		System.out.println("报告正确信息");
//	return "redirect:shoppingcart.do";
//	}else {
//		System.out.println("报告错误信息");
//		return "redirect:fruitsDetail.do";
//	}
//}
//@RequestMapping("/shoppingcart")
//public String Cart(Model model,HttpServletRequest request) {
//	HttpSession session=request.getSession();
//	String username=(String)session.getAttribute("user");
//	User user=cartServiceImpl.findUser(username);
//	int user_id=user.getUserId();
//	List<Orders> list=cartServiceImpl.findCart(user_id);
//	if(list!=null) {
//		model.addAttribute("list",list);
//		model.addAttribute("username",username);
//		Map map=new HashMap();
//		for(int i=0;i<list.size();i++) {
//			int id=list.get(i).getFruitsId();
//			Fruits fruits=cartServiceImpl.findfruitsById(id);
//			String fruitsname=fruits.getFruits_name();
////			System.out.println(bookname);
//			map.put(fruitsname, list.get(i));
//		}
//		model.addAttribute("map",map);
//		return "user/usershoppingcart";
//	}else {
//		System.out.println("购物车为空");
//		model.addAttribute("error","还没有商品！");
//		return "user/usershoppingcart";
//	}
//}
//@RequestMapping("/userdeletebook")
//public String userdeletefruits(Model model,int id,HttpServletRequest request) {
//	HttpSession session=request.getSession();
//	String username=(String)session.getAttribute("user");
//	User user=cartServiceImpl.findUser(username);
//	int userId=user.getUserId();
//	System.out.println("user_id:"+userId+"book_id"+id);
//	boolean flag=cartServiceImpl.deleteFruits(userId,id);
//	if(flag) {
//	
//	return "redirect:shoppingcart.do";
//	}else {
//		System.out.println("。。。。。。。。。。。出错");
//		return "redirect:shoppingcart.do";
//	}
//}
//@RequestMapping("/userdeletebookO")
//public String userdeletefruitsO(Model model,int id,HttpServletRequest request) {
//	HttpSession session=request.getSession();
//	String username=(String)session.getAttribute("user");
//	User user=cartServiceImpl.findUser(username);
//	int userId=user.getUserId();
//	System.out.println("user_id:"+userId+"book_id"+id);
//	boolean flag=cartServiceImpl.downFruits(userId,id);
//	if(flag) {
//		
//		return "redirect: userorders.do";
//		}else {
//			System.out.println("。。。。。。。。。。。出错");
//			return "redirect: userorders.do";
//		}
//
//}
//@RequestMapping("/deleall")
//public String deleall(Model model,HttpServletRequest request) {
//	HttpSession session=request.getSession();
//	String username=(String)session.getAttribute("user");
//	User user=cartServiceImpl.findUser(username);
//	int user_id=user.getUserId();
//	String[] list=request.getParameterValues("dele");
//	for(int i=0;i<list.length;i++) {
//		int id=Integer.parseInt(list[i]);
//		model.addAttribute("book",list[i]);
//		boolean re=cartServiceImpl.deleteFruits(user_id, id);
//		if(re) {
//			continue;
//		}else {
//			break;
//		}
//	}
//	return "redirect:shoppingcart.do";
//}
