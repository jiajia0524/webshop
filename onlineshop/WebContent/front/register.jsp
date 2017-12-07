<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  function checkname(){
	  var value = document.getElementById("nameid").value
	  ;
	  if(value == "") {
		  alert("用户名不能为空！");
	  }
  }
  function checkpsd(){
	  var value = document.getElementById("passwordid").value;
	  if(value == "") {
		  alert("密码不能为空！");
	  }
	  if(value.length > 10){
		  alert("密码长度不能超过10位！");
	  }
  }
</script>
</head>
<body>
<form action="/onlineshop/register" method="post" >
  <table border="0">
     <tr>
       <td>用户名</td>
       <td>
         <input type="text" name="userName" onblur="checkname()" id="nameid"/>
       </td>
     </tr>
     <tr>
       <td>密码</td>
       <td>
         <input type="password" name="userPassword" onblur="checkpsd()" id="passwordid"/>
       </td>
     </tr>
     <!-- 
     <tr>
       <td>确认密码</td>
       <td><input type="password" name="password" /></td>
     </tr>
      -->
      <tr>
       <td>邮箱</td>
       <td><input type="text" name="userEmail" /></td>
     </tr>
     <tr>
       <td><input type="submit" value="注册"/></td>
     </tr>
     
  </table>
</form>
</body>
</html>