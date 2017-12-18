<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
  Object obj = request.getParameter("p");
  int id = Integer.parseInt(obj.toString());;
%>
<form action="/onlineshop/addaddress.do" method="post">
  <input type="hidden" value=<%=id %> name="userId"/>
   收件人：<input type="text" name="name" />
  <br/>
   电话：<input type="text" name="tel" />
  <br/>
  省份：<input type="text" name="province" />
  <br/>
 城市：<input type="text" name="city" />
  <br/>
  地区：<input type="text" name="district" />
  <br/>
  详细地址：<input type="text" name="detail" />
  <br/>
<input type="submit"  />
  
</form>
</body>
</html>