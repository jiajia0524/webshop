package com.blue.fruits.fruitstype.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blue.fruits.entity.Fruitstype;
import com.blue.fruits.fruitstype.service.FruitsTypeServiceImpl;

@Controller
@RequestMapping("fruitstype")
public class FruitsTypeController {
	
	@Resource
    private FruitsTypeServiceImpl fruitsTypeServiceImpl;
	
	@RequestMapping("/typelist")
	public String selectAll(Model model) {
		List<Fruitstype> list = fruitsTypeServiceImpl.selectAll();
		model.addAttribute("typelist",list);
		return "type/type_list";
	}
	
	@RequestMapping("/typedetail")
	public String selectById(Model model, int id) {
		Fruitstype ftype = fruitsTypeServiceImpl.selectById(id);
		model.addAttribute("type",ftype);
		return "type/type_detail";
	}
	
	@RequestMapping("/addtype")
	public String addType(Fruitstype ftype) {
		Boolean b = fruitsTypeServiceImpl.addType(ftype);
		if(b != false) {
			return "succeed";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/updatetype")
	public String updateType(Fruitstype ftype) {
		int i = fruitsTypeServiceImpl.updateType(ftype);
		if(i > 0) {
			return "succeed";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/deletetype")
	public String deleteType(int id) {
		fruitsTypeServiceImpl.deleteType(id);
		return "succeed";
	}

}
