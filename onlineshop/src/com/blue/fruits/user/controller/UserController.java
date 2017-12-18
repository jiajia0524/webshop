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
	private UserServiceImpl userServiceImpl;

	@RequestMapping("/login")
	public String login(@RequestParam("userName") String name,
			@RequestParam("userPassword") String pwd,
			HttpSession session,Model model){
		User lu=this.userServiceImpl.login(name, pwd);
		if(lu!=null){
			session.setAttribute("lu", lu);
			return "front/index";
		}else{
			model.addAttribute("erroinfo", "用户名或密码错误");
			return "error";
		}
	}
	@RequestMapping("/userlist")
	public String selectAll(Model model) {
		List<User> list = userServiceImpl.selectAll();
		model.addAttribute("userlist", list);
		return "backstage/userlist";
	}
	
	@RequestMapping("/username")
	public void selectAllName( Model model) {
		List<String> list = userServiceImpl.selectAllName();
		model.addAttribute("username", list);
	}
	
	@RequestMapping("/register")
	public String Register(Model model,User user) {
		selectAllName(model);
		Boolean b = false;
		if(user != null && user.getUserName() != null && user.getUserPassword() != null
				&& !user.equals("") && !user.getUserName().equals("") && !user.getUserPassword().equals("")) {
			b = userServiceImpl.add(user);
		}
		if(b != false) {
			return "front/login";
		}else {
			model.addAttribute("registerError", "注册失败");
			return "front/register";
		}
	}
	
	@RequestMapping("/preupdateuser")
	public String selectById(Model model,int userId) {
		User user = userServiceImpl.selectById(userId);
		model.addAttribute("user", user);
		//model.addAttribute("sexs", new String[] {"男","女"} );
		//model.addAttribute("likes", new String[] {"游泳","跑步","看书","写作","唱歌","跳舞"});
		return "backstage/user_update";
	}
	
	@RequestMapping("/updateuser")
	public String updateUser(User user) {
		int i = userServiceImpl.updateUser(user);
		if(i >  0) {
			return "succeed";
		}
		return "error";
	}
	
	@RequestMapping("/deleteuser")
	public String deleteUser(int userId) {
		userServiceImpl.deleteUser(userId);
		return "succeed";
	}
	
	@RequestMapping("/userimage")
	public String userImg(HttpServletRequest request,Model model,@RequestParam MultipartFile file, int id) {
		String realPath = request.getServletContext().getRealPath("images_person");
		userServiceImpl.userImg(realPath, file, id);;
		return "succeed";
	}
	
	@RequestMapping("/userShopping")
	public String showShopping(int id) {
		User user = userServiceImpl.selectById(id);
		
		return "user/user_shopping";
	}
	
	public UserServiceImpl getUserService() {
		return userServiceImpl;
	}
	
	public void setUserService(UserServiceImpl userService) {
		this.userServiceImpl = userService;
	}
}