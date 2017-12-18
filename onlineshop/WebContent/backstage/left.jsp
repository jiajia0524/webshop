<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="static/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="static/js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>通讯录</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="static/images/leftico01.png" /></span>蔬果信息管理
    </div>
    	<ul class="menuson">
        <li class="active"><cite></cite><a href="index.jsp" target="rightFrame">首页模版</a><i></i></li>
        <li><cite></cite><a href="${ctx }/fruits/fruits_list4" target="rightFrame">蔬果列表</a><i></i></li>
        <li><cite></cite><a href="addfruits.jsp" target="rightFrame">添加蔬果</a><i></i></li>
        <li><cite></cite><a href="error.jsp" target="rightFrame">404页面</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="static/images/leftico02.png" /></span>购物车管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="${ctx }/cart/cartlist1" target="rightFrame">购物车列表</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="static/images/leftico03.png" /></span>订单管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="${ctx }/orders/orderslist.do" target="rightFrame">订单列表</a><i></i></li>
        <li><cite></cite><a href="#">常用资料</a><i></i></li>
        <li><cite></cite><a href="#">信息列表</a><i></i></li>
        <li><cite></cite><a href="#">其他</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="static/images/leftico04.png" /></span>其他管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="${ctx }/userlist" target="rightFrame">用户信息管理</a><i></i></li>
        <li><cite></cite><a href="${ctx }/backstage/user_update.jsp" target="rightFrame">用户修改页面</a><i></i></li>

    </ul>
    
    </dd>   
    
    </dl>
</body>
</html>
