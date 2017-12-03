<%@ page language="java" contentType="text/html; charset=Utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台左一</title>
</head>
<body>
<a href="fruits/list">蔬果列表</a>
</form>
<a href="addbook.jsp">添加蔬果</a>
<table border="1px">
    <tr>
        <th>蔬果编号</th>
        <th>蔬果名字</th>
        <th>产地</th>
        <th>单位</th>
        <th>描述</th>
        <th>现价</th>
        <th>原价</th>
        <th>类型</th>
        <th>参考图片</th>
    </tr>
    <c:forEach items="${list }" var="f">
    <tr>
        <td>${f.fruits_id }</td>
        <td>${f.fruits_name }</td>
        <td>${f.fruits_producingplace }</td>
        <td>${f.fruits_count }</td>
        <td>${f.fruits_describe }</td>
        <td>${f.fruits_presentprice }</td>
        <td>${f.fruits_originalprice }</td>
        <td>${f.fruitstype_id }</td>
        <td>${f.fruits_image }</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>