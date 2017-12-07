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

import com.blue.fruits.entity.Fruitstype;




@Repository
public class FruitsTypeDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public List<Fruitstype> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Fruitstype");
		List<Fruitstype> list = query.list();
		return list;
	}
	
	public Boolean addType(Fruitstype ftype) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(ftype);
		return true;
	}
	
	public int updateType(Fruitstype ftype) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("update Type set name=? where id=?");
		query.setParameter(0, ftype.getFruitstype_name());;
		query.setParameter(1, ftype.getFruitstype_id());
		int i = query.executeUpdate();
		tx.commit();
		return i;
	}
	
	public void deleteType(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Fruitstype ftype = session.get(Fruitstype.class, new Integer(id));
		session.delete(ftype);
	}

	public Fruitstype selectById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Type where id = ?");
		query.setParameter(0, id);
		Fruitstype type = (Fruitstype)query.uniqueResult();
		return type;
	}

}
