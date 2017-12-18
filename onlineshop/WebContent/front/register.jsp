<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- CSS -->
        <link rel="stylesheet" href="${ctx }/static/loginassets/css/reset.css">
        <link rel="stylesheet" href="${ctx }/static/loginassets/css/supersized.css">
        <link rel="stylesheet" href="${ctx }/static/loginassets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<title>果然新鲜注册页面</title>
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

<div class="page-container">
            <h1>Login</h1>
            <form action="/onlineshop/register" method="post">
                <input type="text" name="userName" class="username" placeholder="Username">
                <input type="password" name="userPassword" class="password" placeholder="Password">
                <input type="text" name="userEmail" placeholder="Email">
                <button type="submit">注册</button>
                <div class="error"><span>+</span></div>
            </form>
            <div class="connect">
                <p>Or connect with:</p>
                <p>
                    <a class="" href="${ctx }/backstage/adminlogin.jsp">管理登录</a>
                    <a class="" href="${ctx }/front/login.jsp">用户登录</a>
                </p>
            </div>
        </div>
		
        <!-- Javascript -->
        <script src="${ctx }/static/loginassets/js/jquery-1.8.2.min.js"></script>
        <script src="${ctx }/static/loginassets/js/supersized.3.2.7.min.js"></script>
        <script src="${ctx }/static/loginassets/js/supersized-init.js"></script>
        <script src="${ctx }/static/loginassets/js/scripts.js"></script>

</body>
</html>