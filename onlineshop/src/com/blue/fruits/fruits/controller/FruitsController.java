package com.blue.fruits.fruits.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    //蔬果热卖获取蔬果列表
	@RequestMapping("/fruits_list1")
	public String flist(Model model,Integer pages) {
//		List<Fruits> list = this.fruitsServiceImpl.listAll();
//		model.addAttribute("list",list);
		Integer totalpages = fruitsServiceImpl.selectTotalpages();
		System.out.println(totalpages);
		if(pages==null) {
			pages = 1;
		}else {
			if(pages<1) {
				pages = 1;
			}	
		    if(pages>totalpages) {
		    	pages = totalpages;
		    }
		}
		List<Fruits> list = fruitsServiceImpl.select(totalpages);
		model.addAttribute("totalpages", totalpages);
		model.addAttribute("pages", pages);
		model.addAttribute("list", list);
		return "front/hot";
		
	}
	//全部产品获取蔬果列表
	@RequestMapping("/fruits_list2")
	public String flist1(Model model) {
		List<Fruits> list = this.fruitsServiceImpl.listAll();
		model.addAttribute("list",list);
		return "front/produ";
		
	}
	//首页获取蔬果列表
	@RequestMapping("/fruits_list3")
	public String flist2(Model model,Integer pages) {
//		List<Fruits> list = this.fruitsServiceImpl.listAll();
//		model.addAttribute("list",list);
		Integer totalpages = fruitsServiceImpl.selectTotalpages();
		System.out.println(totalpages);
		if(pages==null) {
			pages = 1;
		}else {
			if(pages<1) {
				pages = 1;
			}	
		    if(pages>totalpages) {
		    	pages = totalpages;
		    }
		}
		List<Fruits> list = fruitsServiceImpl.select(totalpages);
		model.addAttribute("totalpages", totalpages);
		model.addAttribute("pages", pages);
		model.addAttribute("list", list);
		return "front/index";
		
	}
	//后台获取蔬果列表（right.jsp）
	@RequestMapping("/fruits_list4")
	public String fruitsList(Model model,Integer pages) {
		System.out.println("11111");
		
		Integer totalpages = fruitsServiceImpl.selectTotalpages();
		System.out.println(totalpages);
		if(pages==null) {
			pages = 1;
		}else {
			if(pages<1) {
				pages = 1;
			}	
		    if(pages>totalpages) {
		    	pages = totalpages;
		    }
		}
		List<Fruits> list = fruitsServiceImpl.select(totalpages);
		model.addAttribute("totalpages", totalpages);
		model.addAttribute("pages", pages);
		model.addAttribute("list", list);
		return "backstage/right";
		
	}
	
	@RequestMapping("/fruitsDetail")
	public String selectById(Model model,int id) {
		Fruits f = fruitsServiceImpl.selectById(id);
		model.addAttribute("f",f);
		return "backstage/fruitsDetail";
	}
	//前台蔬果详情
	@RequestMapping("/fruitsDetail1")
	public String selectById1(Model model,int fruits_id) {
		Fruits f = fruitsServiceImpl.selectById(fruits_id);
		model.addAttribute("f",f);
		return "front/fruitsDetail";
	}
	//后台蔬果详情
	@RequestMapping("/fruitsdetail")
	public String selectById2(Model model,int fruits_id) {
		Fruits f = fruitsServiceImpl.selectById(fruits_id);
		model.addAttribute("f",f);
		return "backstage/fruitsdetail";
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
	public String preUpdate(Model model,int fruits_id) {
		Fruits f = fruitsServiceImpl.selectById(fruits_id);
		model.addAttribute("f",f);
		return "backstage/fruits_update";
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
	//后台蔬果删除
	@RequestMapping("/deletefruits")
	public String deleteFruits(int fruits_id) {
		fruitsServiceImpl.deleteFruits(fruits_id);
		return "succeed";
	}
	
	@RequestMapping("/fruitsimg")
	public String fruitsImg(HttpServletRequest request,Model model,@RequestParam MultipartFile file, int id) {
		String realPath = request.getServletContext().getRealPath("fruits_image");
		
		fruitsServiceImpl.fruitsImg(realPath, file, id);
		return "succeed";
	}
	
	
	
	

}
