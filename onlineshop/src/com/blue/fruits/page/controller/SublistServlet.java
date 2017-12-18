//package com.blue.fruits.page.controller;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.blue.fruits.entity.Fruits;
//import com.blue.fruits.entity.Page;
//import com.blue.fruits.page.Constant;
//import com.blue.fruits.page.service.FruitsService;
//import com.blue.fruits.page.service.SublistFruitsServiceImpl;
//
///**
// * Servlet implementation class SublistServlet
// */
////@WebServlet("/SublistServlet")
//public class SublistServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    
//	private FruitsService fruitsService = new SublistFruitsServiceImpl();
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public SublistServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doPost(request,response);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//接收request里的参数
//		String fname = request.getParameter("fruits_name");
//	     
//		int ftype= Constant.DEFAULT_GENDER;
//		String ftype1 = (String)request.getParameter("type_id");
//		if(ftype1!=null && !"".equals(ftype1.trim())) {
//		    ftype = Integer.parseInt(ftype1);
//		}
//		
//		int pageNum1 = Constant.DEFAULT_PAGE_NUM;
//	    String pageNum = request.getParameter("");//显示第几页数据
//	    if(pageNum!=null && !"".equals(pageNum.trim())) {
//	    	pageNum1 = Integer.parseInt(pageNum);
//		}
//	    
//	    int pageSize1 = Constant.DEFAULT_PAGE_SIZE;
//	    String pageSize = request.getParameter("");//每页显示多少条记录
//	    if(pageSize!=null && !"".equals(pageSize.trim())) {
//	    	pageSize1 = Integer.parseInt(pageSize);
//		}
//		//组装查询条件
//		Fruits searchModel = new Fruits();
//		searchModel.setFruits_name(fname);
//		
//		//调用service获取查询结果
////		Page<Fruits> result = fruitsService.findFruits(searchModel, pageNum1, pageSize1);
//		
//		//结果返回到页面
////		request.setAttribute("result", result);
////		request.getRequestDispatcher("sublistFruits.jsp").forward(request, response);
//		
//	}
//
//}
