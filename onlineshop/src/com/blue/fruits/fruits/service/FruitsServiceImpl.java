package com.blue.fruits.fruits.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blue.fruits.entity.Fruits;
import com.blue.fruits.fruits.dao.FruitsDaoImpl;

@Service
@Transactional(readOnly=true)
public class FruitsServiceImpl {
	
	@Resource
	private FruitsDaoImpl fruitsDaoImpl;
	
	public List<Fruits> listAll(){
		return this.fruitsDaoImpl.findAll();
	}

}
