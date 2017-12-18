//package com.blue.fruits.page.controller;
//
//import java.util.List;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.blue.fruits.entity.Fruits;
//import com.blue.fruits.entity.Page;
//import com.blue.fruits.fruits.service.FruitsServiceImpl;
//
//@RequestMapping("pages")
//public class PageController {
//	@Resource
//	private FruitsServiceImpl fruitsServiceImpl;
//	
//	@RequestMapping("select")
//	public String search(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		Object att = session.getAttribute("fruits");
//		List<Fruits> list = null;
//		if(att==null) {
//			list=fruitsServiceImpl.listAll();
//			session.setAttribute("fruits", list);
//			
//		}else {
//			list=(List<Fruits>)att;
//		}
//		String pages=request.getParameter("page");
//		Integer dpage=1;
//		if(pages!=null) {
//			dpage=Integer.parseInt(pages);
//		}
//		Page page = new Page();
//		page.setTotalcount(list.size());
//		page.setTotalpage();
//		page.setDpage(dpage);
//		Integer end = dpage*page.getPagecount();
//		if(end>page.getTotalcount()) {
//			end = page.getTotalcount();
//		}
//		List<Fruits> subList = list.subList((dpage-1)*page.getPagecount(), end);
//		request.getSession().setAttribute("list", subList);
//		request.getSession().setAttribute("page", page);
//		return "redirect:/backstage/fruits_list.jsp";
//	}
//
//
//}
