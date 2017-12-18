package com.blue.fruits.fruits.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blue.fruits.entity.Fruits;
import com.blue.fruits.fruits.dao.FruitsDaoImpl;

@Service
public class FruitsServiceImpl {
	
	@Resource
	private FruitsDaoImpl fruitsDaoImpl;
	
	public List<Fruits> listAll(){
		return this.fruitsDaoImpl.findAll();
	}
	
	public Boolean addFruits(Fruits fruits) {
		Boolean f = fruitsDaoImpl.addFruits(fruits);
		return f;
	}
	
	public Fruits selectById(int id) {
		Fruits fruits = fruitsDaoImpl.selectById(id);
		return fruits;
	}
	
	public int updateFruits(Fruits fruits) {
		int i = fruitsDaoImpl.updateFruits(fruits);
		return i;
	}
	
	public void deleteFruits(int fruits_id) {
		fruitsDaoImpl.deleteFruits(fruits_id);
	}
	
	public void fruitsImg(String realPath,MultipartFile file, int id) {
		fruitsDaoImpl.fruitsImg(realPath, file, id);
	}
	
	public Integer selectTotalpages() {
		return this.fruitsDaoImpl.selectTotalpages();
	}
	public List<Fruits> select(Integer pages){
		return this.fruitsDaoImpl.select(pages);
	}

}
