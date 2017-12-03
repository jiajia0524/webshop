package com.blue.fruits.fruits.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.blue.fruits.entity.Fruits;
import com.blue.fruits.fruits.service.FruitsServiceImpl;



@Controller
@RequestMapping("fruits")
public class FruitsController {
	
	@Resource
	private FruitsServiceImpl fruitsServiceImpl;
	
	@RequestMapping("/list")
	public String list(Model model){
		List<Fruits> list=this.fruitsServiceImpl.listAll();
		model.addAttribute("list", list);
		
		return "backstage/fruits_list";
	}

}
