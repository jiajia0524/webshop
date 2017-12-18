package com.blue.fruits.order.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blue.fruits.entity.Fruits;
import com.blue.fruits.entity.Orders;
import com.blue.fruits.order.service.OrdersServiceImpl;

@Controller
@RequestMapping("orders")
public class OrdersController {
	
	@Resource
	private OrdersServiceImpl ordersServiceImpl;
		
	@RequestMapping("/orderslist")
	public String selectAll(Model model) {
		List<Orders> list = ordersServiceImpl.selectAll();
		model.addAttribute("orderslist", list);
		return "backstage/orderlist";
	}
	
	@RequestMapping("/ordersdetaillist")
	public String selectAllDetail(Model model) {
		List<Orders> list = ordersServiceImpl.selectAll();
		model.addAttribute("ordersdetaillist", list);
		return "backstage/ordersdetaillist";
	}

	@RequestMapping("/userorders")
	public String selectByUserId(Model model,int userId) {
		List<Orders> list = ordersServiceImpl.selectByUserId(userId);
		model.addAttribute("userorders", list);
		return "user/user_orders";
	}
	
	@RequestMapping("/userordersdetail")
	public String userOrdersDetail(Model model,int userId) {
		List<Orders> list = ordersServiceImpl.selectByUserId(userId);
		model.addAttribute("userordersdetail", list);
		return "user/user_ordersDetail";
	}
	
	@RequestMapping("/orders")
	public String selectById(Model model,int orderId) {
		Orders orders = ordersServiceImpl.selectById(orderId);
		model.addAttribute("orders", orders);
		return "orders/orders_list";
	}
	
	@RequestMapping("/ordersdetail")
	public String ordersDetail(Model model,int orderId) {
		Orders orders = ordersServiceImpl.selectById(orderId);
		model.addAttribute("ordersdetail", orders);
		return "orders/ordersdetail";
	}
	
	@RequestMapping("/addorders")
	public String addOrders(Orders orders) {
		Boolean b = ordersServiceImpl.addOrders(orders);
		System.out.println(b);
		if(b != false) {
			return "succeed";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/updateorders")
	public String updateOrders(Orders orders) {
		int i = ordersServiceImpl.updateOrders(orders);
		if(i > 0) {
			return "succeed";
		}else {
			return "error";
		}
	}
	
	public String updateOrderState(int id,int state,int time) {
		int i = ordersServiceImpl.updateOrderState(id, state, time);
		if(i > 0) {
			return "succeed";
		}else {
			return "error";
		}
	}
	
	public String deleteOrders(int id) {
		ordersServiceImpl.deleteOrders(id);
		return "succeed";
	}
	
	public OrdersServiceImpl getOrdersService() {
		return ordersServiceImpl;
	}

	public void setOrdersService(OrdersServiceImpl ordersServiceImpl) {
		this.ordersServiceImpl = ordersServiceImpl;
	}

}



//@RequestMapping("/adminordersall")
//public String adminordersall(Model model ,HttpServletRequest request,Integer pages) {
//	int totalorders=ordersServiceImpl.totalOrders();
//	if(pages==null) {
//		pages=1;
//	}
//	if(pages<1) {
//		pages=1;
//	}
//	if(pages>totalorders) {
//		pages=totalorders;
//	}
//	
//	List<Orders> list=ordersServiceImpl.findOrder(pages);
////	for(int i=0;i<list.size();i++) {
//////		int user_id=list.get(i).getUser_id();
////		User user=adminService.findUserById(user_id);
////		String user_username=user.getUser_username();
////		model.addAttribute("username",user_username);
////		System.out.println(user_username);
////	}
//	System.out.println("...........................");
//	if(list!=null) { 
//		model.addAttribute("orderlist",list);
//		request.setAttribute("list", list);
//		model.addAttribute("pages",pages);
//		model.addAttribute("totalorders",totalorders);
//		return "admin/adminorder";
//	}else {
//		System.out.println("orderlist为空");
//		return "admin/adminorder";
//	}
//	
//}
//@RequestMapping("/admindeleteorders")
//public String admindeleteorders(Model model,Integer id) {
//	boolean del1=ordersServiceImpl.deleteorders(id);
//	if(del1==true) {
//		return "redirect:adminordersall.do";
//	}else {
//		System.out.println("deleteorders执行失败");
//		return "redirect:adminordersall.do";
//	}
//}
//@RequestMapping("/adminupdateorders")
//public String adminupdateorders(Model model, Integer id,String state) {
//	System.out.println(state);
//	if(state.equals("未处理")) {
//		boolean up=ordersServiceImpl.updateorders(id);
//		if(up) {
//			System.out.println("成功");
//			return "redirect:adminordersall.do";
//	}else {
//		System.out.println("措辞                         000000000000000000000");
//		return "redirect:adminordersall.do";
//	}
//		}
//	else {
//		return "redirect:adminordersall.do";
//	}
//	
//}
//@RequestMapping("/ordersdetail")
//public String ordersdetail(Model model,String username) {
//	List<Orders> list=ordersServiceImpl.findByUsername(username);
//	if(list!=null) {
//		model.addAttribute("orderlist",list);
//		model.addAttribute("username",username);
//		List list2=new ArrayList();
//		Map map=new HashMap();
//		
//		
//		for(int i=0;i<list.size();i++) { 
//			int id=list.get(i).getFruitsId();
//			Fruits fruits=ordersServiceImpl.findByFruitsid(id);
//			String fruitsname=fruits.getFruits_name();
//			list2.add(fruitsname);
//			
//			
//			map.put(fruitsname,list.get(i) );
//		}
//		model.addAttribute("map",map);
//		
//		for(int j=0;j<list2.size();j++) {
//		System.out.println(list2.get(j));
//		}
//		model.addAttribute("booknamelist",list2);
//		return "admin/adminordersubmit";
//	}else {
//		model.addAttribute("err","该用户还没有任何订单");
//		return "admin/adminordersubmit";
//		
//	}
//}