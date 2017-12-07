<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="addtype.do" method="post">
  <table border="1">
    <tr>
      <td>类别：<input type="text" name="name" /></td>
    </tr>
    <tr>
      <td><input type="submit" value="添加" /></td>
    </tr>
  </table>
</form>

<table border="1">
  <tr>
    <td>ID</td>
    <td>类别</td>
    <td>操作</td>
  </tr>
  <c:forEach var="type" items="${typelist}">
	<tr>
	      <td><input type="text" name="id" value="${type.id}" /></td>
	      <td><input type="text" name="name" value="${type.name}" /></td>
	      <td>
	        <a href="typedetail.do?id=${type.id}">修改</a>&nbsp;||&nbsp;
	        <a href="deletetype.do?id=${type.id}">删除</a>
	      </td>
	</tr>
  </c:forEach>

</table>

</body>
</html>