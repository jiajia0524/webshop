package com.blue.fruits.fruits.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.blue.fruits.entity.Fruits;


@Repository
public class FruitsDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public List<Fruits> findAll(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Fruits");
		return q.list();
	}

}
