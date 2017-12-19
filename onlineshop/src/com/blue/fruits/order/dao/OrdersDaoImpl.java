package com.blue.fruits.order.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.blue.fruits.entity.Fruits;
import com.blue.fruits.entity.Orders;
import com.blue.fruits.entity.User;


@Repository
public class OrdersDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	
	
	public List<Orders> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Orders");
		List<Orders> list = query.list();
		return list;
	}

	public List<Orders> selectByUserId(int userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Orders where userId = ?");
		query.setParameter(0, userId);
		List<Orders> list = query.list();
		return list;
	}

	public Orders selectById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Orders where orderId = ?");
		query.setParameter(0, id);
		Orders orders = (Orders)query.uniqueResult();
		return orders;
	}

	public Boolean addOrders(Orders orders) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(orders);
		
		
		return true;
	}

	public int updateOrders(Orders orders) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update Orders set userId=?,price=?,"
				+ "time=?,orderState=? where orderId=?");
		query.setParameter(0,orders.getUserId());
		query.setParameter(1,orders.getAddress().getAddressId());
		query.setParameter(2,orders.getPrice());
		query.setParameter(3,orders.getTime());
		query.setParameter(4,orders.getOrderState());
		query.setParameter(5,orders.getOrderId());
		int i = query.executeUpdate();
		return i;
	}

	public int updateOrdersState(int id, int state,int time) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update Orders set time=?, orderState=?where orderId=?");
		query.setParameter(0,time);
		query.setParameter(1,state);
		query.setParameter(2,id);
		int i = query.executeUpdate();
		return i;
	}

	
	public void deleteOrders(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Orders orders = session.get(Orders.class, new Integer(id));
		session.delete(orders);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
