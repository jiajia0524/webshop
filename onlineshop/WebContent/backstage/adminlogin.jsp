<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<link href="static/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="static/js/jquery.js"></script>
<script src="static/js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>

<body style="background-color:#1c77ac; background-image:url(static/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  
    <div class="logintop">    
        <span>欢迎登录后台管理界面平台</span>    
        <ul>
            <li><a href="#">回首页</a></li>
            <li><a href="#">帮助</a></li>
            <li><a href="${ctx }/front/login.jsp">返回用户登录</a></li>
        </ul>    
    </div>
    <div class="loginbody">
        <span class="systemlogo"></span> 
        <div class="loginbox">
            <form action="/onlineshop/adminlogin">
                <ul>
                    <li><input name="adminName" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
                    <li><input name="adminPassword" type="text" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/></li>
                    <li><input name="" type="submit" class="loginbtn" value="登录"   /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
                </ul>
                <!-- onclick="javascript:window.location='main.html'" -->
            </form>
        </div> 
    </div>
</body>
</html>
