package com.blue.fruits.admin.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.blue.fruits.entity.User;
@Repository
public class AdminDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public User findById(String name){
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from User where adminName = ?");
				q.setParameter(0, name);
		User user = (User) q.uniqueResult();
		return user;
	}

}
