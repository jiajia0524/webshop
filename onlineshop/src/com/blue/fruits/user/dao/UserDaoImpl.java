package com.blue.fruits.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.blue.fruits.entity.User;



@Repository
public class UserDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public User findById(String name){
		return this.sessionFactory.getCurrentSession().get(User.class, name);
	}

}
