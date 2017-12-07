package com.blue.fruits.fruitstype.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blue.fruits.entity.Fruitstype;
import com.blue.fruits.fruitstype.dao.FruitsTypeDaoImpl;


@Service
@Transactional(readOnly=true)
public class FruitsTypeServiceImpl {
	
	@Resource
    private FruitsTypeDaoImpl fruitsTypeDaoImpl;
	
	public List<Fruitstype> selectAll() {
		List<Fruitstype> list = fruitsTypeDaoImpl.selectAll();
		return list;
	}
	
	public Fruitstype selectById(int id) {
		Fruitstype type = fruitsTypeDaoImpl.selectById(id);
		return type;
	}
	
	public Boolean addType(Fruitstype ftype) {
		Boolean f =fruitsTypeDaoImpl.addType(ftype);
		return f;
	}
	
	public int updateType(Fruitstype ftype) {
		int i = fruitsTypeDaoImpl.updateType(ftype);
		return i;
	}
	
	public void deleteType(int id) {
		fruitsTypeDaoImpl.deleteType(id);
	}

}
