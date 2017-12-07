<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>蔬果详情</title>
</head>
<body>
<div class="body">
	<div class="left">
	  <img src="${ctx }/static/images/${f.fruits_image}" alt="图片" 
	  width="250px" height="350px"/>
	</div>
	<div class="right">
	  <table border="1px">
	    <tr height="50px">
	      <td width="100px">id</td>
	      <td width="200px">${f.fruits_id}</td>
	    </tr>
	    <tr height="50px">
	      <td width="100px">蔬果名称</td>
	      <td width="200px">${f.fruits_name}</td>
	    </tr>
	    <tr height="50px">
	      <td width="100px">原价</td>
	      <td width="200px">${f.fruits_presentprice}</td>
	    </tr>
	    <tr height="50px">
	      <td width="100px">类型</td>
	      <td width="200px">${f.fruitstype_id.fruitstype_name}</td>
	    </tr>
	    <tr height="50px">
	      <td width="100px">介绍</td>
	      <td width="200px">${f.fruits_describe}</td>
	    </tr>
	    <tr height="50px">
	      <td width="100px">产地</td>
	      <td width="200px">${f.fruits_producingplace}</td>
	    </tr>
	    <tr height="50px">
	      <td ><a href="">加入购物车</a></td>
	    </tr>
	  </table>
	  
	</div>
	</div>

</body>
</html>