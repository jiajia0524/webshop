<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>购物车列表</title>
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
    <li><a href="#">购物车列表</a></li>
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
    <th width="10px;">缩略图</th>
    <th>商品信息</th>
    <th>购买者</th>
    <th>单价</th>
    <th>管理员</th>
    <th>状态</th>
    <th>点击</th>
    </tr>
    </thead>
    
    <tbody>
    <c:forEach items="${cartlist }" var="c">
        <tr>
    <td class="imgtd"><img src="${ctx }/static/images/${c.fruits.fruits_image}" /></td>
    <td><a href="">${c.fruits.fruits_name }</a><p>${c.fruits.fruits_count }</p></td>
    <td>${c.user.userName }</td>
    <td>￥${c.fruits.fruits_presentprice }</td>
    <td>admin</td>
    <td>未提交</td>
    <td>128</td>
    </tr>
    
    </c:forEach>
    </tbody>
    
    </table>
    
    
    
    
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">${totalpages }</i>页，当前显示第&nbsp;<i class="blue">${pages }&nbsp;</i>页</div>
        <ul class="paginList">
        <c:if test="${pages>1 }"><!-- 当当前页码>1时 显示首页和上一页 -->
        <li class="paginItem"><a href="${ctx }/fruits/fruits_list4.do?pages=1">首页</a></li>
        <li class="paginItem"><a href="${ctx }/fruits/fruits_list4.do?pages=${(pages<1)?pages:(pages-1)}">上一页</a></li>
        </c:if>
        <c:if test="${pages<totalpages }">
        <li class="paginItem"><a href="${ctx }/fruits/fruits_list4.do?pages=${(pages>=totalpages)?totalpages:(pages+1)}">下一页</a></li>
        <li class="paginItem"><a href="${ctx }/fruits/fruits_list4.do?pages=${totalpages}">尾页</a></li>
        </c:if>
         </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="${ctx }/backstage/static/images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="${ctx }/backstage/static/images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
