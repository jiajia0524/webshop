<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单列表信息</title>
<link href="${ctx }/backstage/static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx }/backstage/static/js/jquery.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>
<body>

    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">用户列表信息</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="${ctx }/backstage/static/images/t01.png" /></span>添加</li>
        <li class="click"><span><img src="${ctx }/backstage/static/images/t02.png" /></span>修改</li>
        <li><span><img src="${ctx }/backstage/static/images/t03.png" /></span>删除</li>
        <li><span><img src="${ctx }/backstage/static/images/t04.png" /></span>统计</li>
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="${ctx }/backstage/static/images/t05.png" /></span>设置</li>
        </ul>
    
    </div>



<table class="imgtable">
    
    <thead>
    <tr>
    <th width="10px;">ID</th>
    <th>用户ID</th>
    <th>地址ID</th>
    <th>总价格</th>
    <th>时间</th>
    <th>操作</th>
    </tr>
    </thead>
    
    <tbody>
    <c:forEach items="${orderslist}" var="o">
        <tr>
   
    <td><a href="">${o.orderId}</a></td>
    <td>${o.userId}</td>
    <td>${o.address.addressId}</td>
    <td>${o.price}</td>
    <td>${o.time}</td>
      <td>
        <a href="/onlineshop/orders/ordersdetail.do?orderId=${o.orderId}">详情</a>&nbsp;||&nbsp;
        <a href="">修改</a>&nbsp;||&nbsp;
        <a href="">删除</a>
      </td>
    </tr>
    
    </c:forEach>
    </tbody>
    
    </table>

</body>
</html>