package com.blue.fruits.fruits.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.blue.fruits.entity.Fruits;
import com.blue.fruits.fruits.service.FruitsServiceImpl;




@Controller
@RequestMapping("fruits")
public class FruitsController {
	
	@Resource
	private FruitsServiceImpl fruitsServiceImpl;
	
	@RequestMapping("/fruits_list")
	public String list(Model model){
		List<Fruits> list=this.fruitsServiceImpl.listAll();
		model.addAttribute("list", list);
		
		return "backstage/fruits_list";
	}
	@RequestMapping("/fruits_list1")
	public String flist(Model model) {
		List<Fruits> list = this.fruitsServiceImpl.listAll();
		model.addAttribute("list",list);
		return "front/hot";
		
	}
	@RequestMapping("/fruits_list2")
	public String flist1(Model model) {
		List<Fruits> list = this.fruitsServiceImpl.listAll();
		model.addAttribute("list",list);
		return "front/produ";
		
	}
	@RequestMapping("/fruitsDetail")
	public String selectById(Model model,int id) {
		Fruits f = fruitsServiceImpl.selectById(id);
		model.addAttribute("f",f);
		return "backstage/fruitsDetail";
	}
	
	@RequestMapping("/addfruits")
	@ResponseBody
	public String addFruits(Fruits fruits) {
		Boolean f = fruitsServiceImpl.addFruits(fruits);
		if(f != false) {
			return "succeed";
		}else {
			return "error";
		}
	}
	
	@RequestMapping("/preupdatefruits")
	public String preUpdate(Model model,int id) {
		Fruits f = fruitsServiceImpl.selectById(id);
		model.addAttribute("f",f);
		return "fruits_update";
	}
	
	@RequestMapping("/updatefruits") 
	public String updateFruits(Fruits fruits) {
		int i = fruitsServiceImpl.updateFruits(fruits);
		if(i > 0) {
			return "backstage/addfruits";
		}else {
			return "backstage/addfruits";
		}
	}
	
	@RequestMapping("/deletefruits")
	public String deleteFruits(int id) {
		fruitsServiceImpl.deleteFruits(id);
		return "succeed";
	}
	
	@RequestMapping("/fruitsimg")
	public String fruitsImg(HttpServletRequest request,Model model,@RequestParam MultipartFile file, int id) {
		String realPath = request.getServletContext().getRealPath("images_fruits");
		
		fruitsServiceImpl.fruitsImg(realPath, file, id);
		return "succeed";
	}

}
