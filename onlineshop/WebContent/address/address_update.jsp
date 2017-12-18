<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="address" action="/webshopping/updateaddress.do">
  <form:input path="id"/>
  <br/>
  <form:input path="userId"/>
  <br/>
  <form:input path="name"/>
  <br/>
  <form:input path="tel"/>
  <br/>
  <form:input path="province"/>
  <br/>
  <form:input path="city"/>
  <br/>
  <form:input path="district"/>
  <br/>
  <form:input path="detail"/>
  <br/>
  <input type="submit" />
</form:form>
</body>
</html>