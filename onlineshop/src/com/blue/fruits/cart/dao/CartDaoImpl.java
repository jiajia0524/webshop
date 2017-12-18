package com.blue.fruits.cart.dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//
import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.blue.fruits.entity.Fruits;
import com.blue.fruits.entity.Orders;
import com.blue.fruits.entity.User;

import com.blue.fruits.entity.Cart;
import com.blue.fruits.entity.Fruits;
import com.blue.fruits.entity.User;



@Repository
public class CartDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public List<Cart> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart");
		List<Cart> list = query.list();
		return list;
	}

	public List<Cart> selectByUserId(int userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where userId=?");
		query.setParameter(0, userId);
		List<Cart> list = query.list();
		return list;
	}
	public List<Cart> selectById(String[] c){
		Session session = sessionFactory.openSession();
		List<Cart> list = new ArrayList<Cart>();
		for(int i =0; i < c.length; i ++) {
			Query query = session.createQuery("from Cart where cartId=?");
			query.setParameter(0, Integer.parseInt(c[i]));
			Cart cart = (Cart)query.uniqueResult();
			list.add(cart);
		}
		return list;
	}
	
	public Boolean addCart(int userId, int fruitsId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Fruits where fruits_id=?");
		query.setParameter(0,fruitsId);
		Fruits fruits = (Fruits) query.uniqueResult();
		
		User user = session.get(User.class, new Integer(userId));
		Set<Cart> set = user.getCartSet();
		Iterator<Cart> it = set.iterator();
		while(it.hasNext()) {
			Cart c = it.next();
			if(c.getFruits().getFruits_id().equals(fruitsId)) {
				int count = c.getCount();
				c.setCount(count+1);
				session.update(c);
				tx.commit();
				session.close();
				return true;
			}
		}
		Cart c = new Cart();
		c.setFruits(fruits);
		c.setCount(1);
		c.setUser(user);
		user.getCartSet().add(c);
		session.save(c);
		session.update(user);
		tx.commit();
		session.close();
		return true;
	}

	public void deleteCart(int cartId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Cart cart = session.get(Cart.class,new Integer(cartId));
		session.delete(cart);
		tx.commit();
		session.close();
	}
	
	public User addCount(int id) {
		Session session = sessionFactory.getCurrentSession();
		Cart cart = session.get(Cart.class, new Integer(id));
		int count = cart.getCount();
		cart.setCount(count+1);
		session.update(cart);
		int userId = 1;
		Query query = session.createQuery("from User where id=?");
		query.setParameter(0, userId);
		User user = (User) query.uniqueResult();
		//User user = session.get(User.class, new Integer(shopping.getUser().getId()));
		//Query query = session.createQuery("select user from Shopping where id=?");
		//query.setParameter(0, id);
		//User user = shopping.getUser();
		return user;
	}
	
	public void misCount(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Cart cart = session.get(Cart.class, new Integer(id));
		int count = cart.getCount();
		cart.setCount(count-1);
		session.update(cart);
		tx.commit();
		session.close();
	}
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

//@Resource
//JdbcTemplate jdbcTemplate;
//
//public JdbcTemplate getJdbcTemplate() {
//	return jdbcTemplate;
//}
//public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//	this.jdbcTemplate = jdbcTemplate;
//}
//
//public boolean deleteFruits(int userId, int id) {
//	Session session=sessionFactory.getCurrentSession();
//	Query query=session.createQuery("delete from Orders where userId=? and bookId=?");
//	query.setParameter(0, userId);
//	query.setParameter(1, id);
//	int i=query.executeUpdate();
////	System.out.println(i);
//	if(i>0) {
//		
//		return true;
//	}else {
//		return false;
//	}
//	
//}
//
//public User findUser(String userName) {
//	Session session=sessionFactory.getCurrentSession();
//	Query query=session.createQuery("from User where userName=?").setParameter(0, userName);
//	User user=(User)query.uniqueResult();
//	return user;
//}
//
//public boolean addFruits(int userId, int fruits_id, int num, int fruits_presentprice, Date now) {
//	 java.sql.Date now1=new  java.sql.Date(now.getTime());
//	
//	int i=jdbcTemplate.update("insert into  orders(userId,orderState,fruitsId,count,price,time)values(?,?,?,?,?,?)",userId,"未付款",fruits_id,num,fruits_presentprice,now1);
//	
//	if(i>0) {
//		return true;
//	}else {
//		return false;
//	}
//	
//}
//
//public List<Orders> findCart(int userId) {
//	Session session=sessionFactory.getCurrentSession();
//	Query query=session.createQuery("from Orders  where user_id=? and order_state='未付款'").setParameter(0, userId);
//	List<Orders> s=query.list();
//	return s;
//}
//
//public Fruits findfruitsById(int id) {
//	Session session=sessionFactory.getCurrentSession();
//	Query query=session.createQuery("from Fruits where fruits_id=?").setParameter(0, id);
//	Fruits fruits =(Fruits)query.uniqueResult();
//	return fruits;
//}
//
//public boolean downFruits(int user_id, int id) {
//	Session session=sessionFactory.getCurrentSession();
//	Query query =session.createQuery("update  Orders set order_state='已取消订单' where user_id=? and book_id=?");
//	query.setParameter(0, user_id);
//	query.setParameter(1, id);
//	int i=query.executeUpdate();
//	if(i>0){
//		return true;
//	}else {
//		return false;
//	}
//}
