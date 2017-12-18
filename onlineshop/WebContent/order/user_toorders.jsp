<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.text.SimpleDateFormat" %>
    <%@page import="java.util.Date" %>
    <%@page import="java.util.List" %>
    <%@page import="java.util.Iterator" %>
    <%@page import="com.blue.fruits.entity.User" %>
    <%@page import="com.blue.fruits.entity.Fruits" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车添加到订单</title>
</head>
<body>
<%
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  Date date = new Date();
  String time=simpleDateFormat.format(date).toString();
  
%>
<form action="/onlineshop/orders/addorders.do" method="post">
${lu.userId }
<input type="hidden" name="userId" value="${lu.userId}" />
<h3>地址</h3>
<table border="1">
  <c:forEach var="a" items="${lu.addressSet}">
    <tr>
      <td><input type="radio" name="address" value="${a.addressId}" /></td>
      <td>${a.addressName}</td>
      <td>${a.addressTel}</td>
      <td>${a.addressProvince} ${a.addressCity} ${a.addressDistrict} ${a.addressDetail}</td>
    </tr>
  </c:forEach>
</table>
<h3>时间</h3>
<input type="text" name="time" value="<%=time %>" />
<h3>确定订单</h3>
<table border="1">
  <c:forEach var="s" items="${toorders}">
    <tr>
      <td><input type="hidden" name="fruits" value="${s.fruits.fruits_id}" /></td>
      <td>${s.fruits.fruits_name}</td>
      <td>${s.fruits.fruits_presentprice}</td>
      <td>${s.count}</td>
    </tr>
  </c:forEach>
</table>
<h3>总价格</h3>
<input type="text" name="price" value="${sum}" />
<h3>支付</h3>
<input type="radio" name="state" value="0" />未支付
<input type="radio" name="state" value="1"/>支付
<br/>
<input type="submit" value="确定"/>
<input type="button" value="取消" onclick="window.location='cart.jsp'" />
</form>
</body>
</html>