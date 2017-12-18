<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
  <tr>
  	<td>订单ID</td>
    <td>用户ID</td>
    <td>书名</td>
    <td>价格</td>
    <td>地址</td>
    <td>收件人</td>
    <td>电话</td>
  </tr>
    <c:forEach var="b" items="${ordersdetail.fruitsSet}">
      <tr>
        <td>${ordersdetail.orderId}</td>
        <td>${ordersdetail.userId}</td>
        <td>${b.name}</td>
        <td>${b.price}</td>
        <td>${ordersdetail.address.addressProvince} ${o.address.city}</td>
        <td>${ordersdetail.address.addressName}</td>
        <td>${ordersdetail.address.addressTel}</td>
        <td>
          <a href="">详情</a>&nbsp;||&nbsp;
          <a href="">修改</a>&nbsp;||&nbsp;
          <a href="">删除</a>
        </td>
      </tr>
    </c:forEach>
</table>
</body>
</html>