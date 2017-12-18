package com.blue.fruits.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blue.fruits.entity.User;
import com.blue.fruits.user.service.UserServiceImpl;

@Controller
public class AdminController {
	
	@Resource
	private UserServiceImpl userServiceImpl;

	@RequestMapping("/adminlogin")
	public String login(@RequestParam("adminName") String name,
			@RequestParam("adminPassword") String pwd,
			HttpSession session,Model model){
		User lu=this.userServiceImpl.login(name, pwd);
		if(lu!=null){
			session.setAttribute("lu", lu);
			return "backstage/main";
		}else{
			model.addAttribute("erroinfo", "用户名或密码错误");
			return "error";
		}
	}

}
