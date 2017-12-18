package com.blue.fruits.address.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;

import com.blue.fruits.entity.Address;



@Repository
public class AddressDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public Boolean addAddress(Address address) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(address);
		tx.commit();
		session.close();
		return true;
	}

	public List<Address> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Address");
		List<Address> list = query.list();
		return list;
	}

	public Address selectById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Address where addressId = ?");
		query.setParameter(0, id);
		Address address = (Address)query.uniqueResult();
		return address;
	}

	public List<Address> selectByUserId(int userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Address where userId = ?");
		query.setParameter(0, userId);
		List<Address> list = (List<Address>)query.list();
		return list;
	}
	
	public int updateAddress(Address address) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("update Address set addressName=?,addressTel=?, addressProvince=?,addressCity=?,addressDistrict=?,addressDetail=? where addressId=?");
		query.setParameter(0, address.getAddressName());
		query.setParameter(1, address.getAddressTel());
		query.setParameter(2, address.getAddressProvince());
		query.setParameter(3, address.getAddressCity());
		query.setParameter(4, address.getAddressDistrict());
		query.setParameter(5, address.getAddressDetail());
		query.setParameter(6, address.getAddressId());
		
		int i = query.executeUpdate();
		tx.commit();
		return i;
	}
	
	public void deleteAddress(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Address address = session.get(Address.class,new Integer(id));
		session.delete(address);
		tx.commit();
		session.close();
		
	}


}
