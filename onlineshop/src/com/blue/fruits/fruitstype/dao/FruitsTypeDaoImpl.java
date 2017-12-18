package com.blue.fruits.fruitstype.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blue.fruits.entity.FruitsType;


@Repository
public class FruitsTypeDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public List<FruitsType> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from FruitsType");
		List<FruitsType> list = query.list();
		return list;
	}
	
	public Boolean addType(FruitsType ftype) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(ftype);
		return true;
	}
	
	public int updateType(FruitsType ftype) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("update FruitsType set fruitstype_name=? where fruitstype_id=?");
		query.setParameter(0, ftype.getFruitstype_name());;
		query.setParameter(1, ftype.getFruitstype_id());
		int i = query.executeUpdate();
		tx.commit();
		return i;
	}
	
	public void deleteType(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		FruitsType ftype = session.get(FruitsType.class, new Integer(id));
		session.delete(ftype);
	}

	public FruitsType selectById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from FruitsType where fruitstype_name = ?");
		query.setParameter(0, id);
		FruitsType type = (FruitsType)query.uniqueResult();
		return type;
	}

}
