package com.blue.fruits.user.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

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
	
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		return list;
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
	
	public User selectById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where id = ?");
		query.setParameter(0, id);
		User user = (User)query.uniqueResult();
		return user;
	}

	public int updateUser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("update User set userName=?,userPassword=?,userEmail=?,userImage=? where userId=?");
		query.setParameter(0, user.getUserName());
		query.setParameter(1, user.getUserPassword());
		query.setParameter(2, user.getUserEmail());
		query.setParameter(6, user.getUserImage());
		query.setParameter(7, user.getUserId());
		int i = query.executeUpdate();
		tx.commit();
		session.close();
		return i;
	}

	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = session.get(User.class,new Integer(userId));
		session.delete(user);
		tx.commit();
		session.close();
	}

	public void userImg(String realPath, MultipartFile file, int id) {
		// TODO Auto-generated method stub
		if(file != null) {
			String name = file.getName();
			String originalFilename = file.getOriginalFilename();
			if(originalFilename != null && !originalFilename.equals("") ) {
				int start = originalFilename.lastIndexOf("\\") + 1;
				String filename = originalFilename.substring(start);
				try {
					byte[] bytes = file.getBytes();
					File f = new File(realPath + "\\" + filename);
					FileOutputStream fos = new FileOutputStream(f);
					fos.write(bytes);
					fos.flush();
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				User user = selectById(id);
				user.setUserImage(filename);
				int i = updateUser(user);
			}
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
