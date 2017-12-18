<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
</head>
<body>
    <form:form modelAttribute="user" action="/onlineshop/updateuser.do">
  <table border="0">
    <tr>
       <td>头像</td>
       <td><img src="images_person/${user.userImage}" width="50px" height="50px"></td>
     </tr>
    <tr>
       <td>账号</td>
       <td><form:input path="userId"/></td>
     </tr>
     <tr>
       <td>用户名</td>
       <td><form:input path="userName"/></td>
     </tr>
     <tr>
       <td>密码</td>
       <td><form:input path="userPassword" /></td>
     </tr>
     <!-- 
     <tr>
       <td>确认密码</td>
       <td><input type="text" name="name" /></td>
     </tr>
      -->
     <tr>
       <td>邮箱</td>
       <td><form:input path="userEmail" /></td>
     </tr>
     <tr>
       <td><input type="submit"/>
     </tr>
     
  </table>
</form:form>
<form action="/onlineshop/userimage.do?userId=${user.userId}" method="post" enctype="multipart/form-data">
	    <input type="file" name="file"/>
	    <input type="submit" />
</form>
</body>
</html>