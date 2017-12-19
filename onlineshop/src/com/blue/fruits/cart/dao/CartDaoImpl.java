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
