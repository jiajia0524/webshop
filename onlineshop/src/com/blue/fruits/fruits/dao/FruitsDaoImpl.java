package com.blue.fruits.fruits.dao;

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

import com.blue.fruits.entity.Fruits;
import com.blue.fruits.entity.Fruitstype;




@Repository
public class FruitsDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	//查询蔬果
	public List<Fruits> findAll(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Fruits");
		return q.list();
	}
	//添加蔬果
	public Boolean addFruits(Fruits fruits) {
		Session session = sessionFactory.getCurrentSession();
		session.save(fruits);
		return true;
	}
	//通过ID查询蔬果
	public Fruits selectById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Fruits where fruits_id = ?");
		query.setParameter(0, id);
		Fruits f= (Fruits)query.uniqueResult();
		return f;
	}
	//更新蔬果
	public int updateFruits(Fruits fruits) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		int id = fruits.getType_id();
		Query typeQuery = session.createQuery("from Fruitstype where type_id=?");
		typeQuery.setParameter(0, id);
		Fruitstype t = (Fruitstype)typeQuery.uniqueResult();
		String typename = t.getFruitstype_name();
		
		Query query = session.createQuery("update Fruits set fruits_name=?,fruits_count=?,fruits_describe=?,fruits_presentprice=?,fruits_originalprice=?,type_id=?,typename=?,fruits_producingplace=?,fruits_image=? where fruits_id=?");
		query.setParameter(0, fruits.getFruits_name());
		query.setParameter(1, fruits.getFruits_count());
		query.setParameter(2, fruits.getFruits_describe());
		query.setParameter(3, fruits.getFruits_presentprice());
		query.setParameter(4, fruits.getFruits_originalprice());
		query.setParameter(5, fruits.getType_id());
		query.setParameter(6, typename);
		query.setParameter(7, fruits.getFruits_producingplace());
		query.setParameter(8, fruits.getFruits_image());
		query.setParameter(9, fruits.getFruits_id());
		int i = query.executeUpdate();
		tx.commit();
		return i;
	}
	//删除蔬果
	public void deleteFruits(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Fruits f = session.get(Fruits.class, new Integer(id));
		session.delete(f);
	}
	
	//
	public void fruitsImg(String realPath,MultipartFile file, int id) {
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
				Fruits f = selectById(id);
				f.setFruits_image(filename);
				int i = updateFruits(f);
			}
		}
	}
	

}
