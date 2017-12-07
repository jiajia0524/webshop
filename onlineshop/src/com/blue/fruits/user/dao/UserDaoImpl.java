package com.blue.fruits.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.blue.fruits.entity.User;



@Repository
public class UserDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public User findById(String name){
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from User where userName = ?");
		q.setParameter(0, name);
		User user = (User) q.uniqueResult();
		return user;
	}
	
	public List<String> selectAllName() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("select userName from User");
		return q.list();
	}
	
	public Boolean add(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		return true;
	}

}
