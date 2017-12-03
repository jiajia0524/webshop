package com.blue.fruits.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.blue.fruits.entity.User;
import com.blue.fruits.user.service.UserServiceImpl;

@Controller
public class UserController {
	
	@Resource
	private UserServiceImpl UserServiceImpl;

	@RequestMapping("/login")
	public String login(@RequestParam("user_name") String name,
			@RequestParam("user_password") String pwd,
			HttpSession session,Model model){
		User lu=this.UserServiceImpl.login(name, pwd);
		if(lu!=null){
			session.setAttribute("lu", lu);
			return "front/index";
		}else{
			model.addAttribute("erroinfo", "用户名或密码错误");
			return "error";
		}
	}
}