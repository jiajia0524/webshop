package com.blue.fruits.fruitstype.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blue.fruits.entity.FruitsType;
import com.blue.fruits.fruitstype.dao.FruitsTypeDaoImpl;


@Service
@Transactional(readOnly=true)
public class FruitsTypeServiceImpl {
	
	@Resource
    private FruitsTypeDaoImpl fruitsTypeDaoImpl;
	
	public List<FruitsType> selectAll() {
		List<FruitsType> list = fruitsTypeDaoImpl.selectAll();
		return list;
	}
	
	public FruitsType selectById(int id) {
		FruitsType type = fruitsTypeDaoImpl.selectById(id);
		return type;
	}
	
	public Boolean addType(FruitsType ftype) {
		Boolean f =fruitsTypeDaoImpl.addType(ftype);
		return f;
	}
	
	public int updateType(FruitsType ftype) {
		int i = fruitsTypeDaoImpl.updateType(ftype);
		return i;
	}
	
	public void deleteType(int id) {
		fruitsTypeDaoImpl.deleteType(id);
	}

}
