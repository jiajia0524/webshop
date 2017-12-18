package com.blue.fruits.order.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blue.fruits.entity.Fruits;
import com.blue.fruits.entity.Orders;
import com.blue.fruits.order.dao.OrdersDaoImpl;




@Service
public class OrdersServiceImpl {
	
	@Resource
	private OrdersDaoImpl ordersDaoImpl;
	
	
	
	public List<Orders> selectAll(){
		List<Orders> list = ordersDaoImpl.selectAll();
		return list;
	}
	public List<Orders> selectByUserId(int userId){
		List<Orders> list = ordersDaoImpl.selectByUserId(userId);
		return list;
	}
	public Orders selectById(int id) {
		Orders order = ordersDaoImpl.selectById(id);
		return order;
	};
	public Boolean addOrders(Orders orders) {
		Boolean b = ordersDaoImpl.addOrders(orders);
		return b;
	};
	public int updateOrders(Orders orders) {
		int i = ordersDaoImpl.updateOrders(orders);
		return i;
	};
	public int updateOrderState(int id,int state,int time) {
		int i = ordersDaoImpl.updateOrdersState(id, state, time);
		return i;
	};
	public void deleteOrders(int id) {
		ordersDaoImpl.deleteOrders(id);
	}
	public OrdersDaoImpl getOrdersDao() {
		return ordersDaoImpl;
	}
	public void setOrdersDao(OrdersDaoImpl ordersDaoImpl) {
		this.ordersDaoImpl = ordersDaoImpl;
	};

}

//public int totalUsers() {
//	int totalpages=ordersDaoImpl.totalUsers();
//	return totalpages; 
//}
//public List<Orders> findOrder(int pages) {
//	List<Orders> list=ordersDaoImpl.findOrder(pages);
//	return list;
//}
//public boolean updateorders(Integer id) {
//	boolean up=ordersDaoImpl.updateorders(id);
//	return up;
//}
//
//public int totalOrders() {
//	int totalpages=ordersDaoImpl.totalOrders();
//	return totalpages;
//}
//public List<Orders> findByUsername(String username) {
//	List<Orders> list=ordersDaoImpl.findByUsername(username);
//	return list;
//}
//public boolean deleteorders(Integer orderId) {
//	boolean del=ordersDaoImpl.deleteorders(orderId);
//	return del;
//}
//public Fruits findByFruitsid(Integer id) {
//	Fruits book=ordersDaoImpl.adminfindbyfruitsid(id);
//	return book;
//}
