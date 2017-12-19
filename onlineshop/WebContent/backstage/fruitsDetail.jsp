<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>蔬果详情</title>
</head>
<body>
<div class="body">
	<div class="left">
	  <img src="${ctx }/static/images/${f.fruits_image}" alt="封面" />
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
	      <td width="100px">类别</td>
	      <td width="200px">${f.fruitstype_id.fruitstype_name}</td>
	    </tr>
	    <tr height="50px">
	      <td width="100px">价格</td>
	      <td width="200px">${f.fruits_presentprice}</td>
	    </tr>
	  </table>
	  
	</div>
	</div>
</body>
</html>