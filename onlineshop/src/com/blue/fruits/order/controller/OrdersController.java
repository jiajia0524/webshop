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
