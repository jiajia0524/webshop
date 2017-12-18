<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${ctx }/static/css/reset.css">
    <link rel="stylesheet" href="${ctx }/static/css/carts.css">
    <link href="${ctx }/static/css/orange.css"rel="stylesheet">
    <link href="${ctx }/static/css/index.css"rel="stylesheet">
    <link href="${ctx }/static/css/share.css"rel="stylesheet">
    <script src="${ctx }/static/js/jquery-1.12.3.js"></script>
    <script type="text/javascript" src="${ctx }/static/js/jquery.SuperSlide.2.1.1.js"></script>
<title>果然新鲜购物车</title>
</head>
<body>
<!--顶部导航-->
<div class="headr">
    <div class="heard-con">
        <img src="${ctx }/static/images/logo.jpg" style="margin-top: 7px;float: left;position: absolute">
        <div class="headr-nav">
            <ul>
                <li><a href="${ctx }/fruits/fruits_list3">首页</a> </li>
                <li><a href="${ctx }/fruits/fruits_list1">蔬果热卖</a> </li>
                <li><a href="${ctx }/fruits/fruits_list2">全部产品</a> </li>
                <li><a href="#">${lu.userName }</a></li>
                <li><a href="${ctx }/front/login.jsp">退出登录</a> </li>
                      
            </ul>
            
            <div class="sptopfoot">
                <div class="spbottom"  >
                </div>
            </div>
        </div>
        <div class="headr-right" style="color: #4AB344">
            
            <i class="iconfont" style="font-size: 16px;margin-right: 10px">&#xe7d5;</i>
            我的购物车 ∨
        </div>
    </div>
</div>
<!--顶部导航结束-->
<!-- 购物车主体开始 -->
<section class="cartMain">
    <form action="/onlineshop/cart/carttoorders" method="post">
        <div class="cartMain_hd">
            <ul class="order_lists cartTop">
                <li class="list_chk">
                    <!--所有商品全选-->
                    <input type="checkbox" id="all" class="whole_check">
                    <label for="all"></label>
                    全选
                </li>
                <li class="list_con">商品信息</li>
                <li class="list_info">购买者</li>
                <li class="list_price">单价</li>
                <li class="list_amount">数量</li>
                <li class="list_sum">金额</li>
                <li class="list_op">操作</li>
            </ul>
        </div>
        <div class="order_content">
            <c:forEach items="${lu.cartSet }" var="c">
                <ul class="order_lists">
                    <li class="list_chk">
                        <input type="checkbox" id="checkbox_2" name="cart" class="son_check" value="${c.cartId }">
                        <label for="checkbox_2"></label>
                    </li>
                    <li class="list_con">
                        <div class="list_img"><a href="javascript:;"><img src="${ctx }/static/images/${c.fruits.fruits_image}" alt=""></a></div>
                        <div class="list_text"><a href="">${c.fruits.fruits_name }</a><p>${c.fruits.fruits_count }</p></div>
                    </li>
                    <li class="list_info">
                        <p>${c.user.userName }</p>
                    </li>
                    <li class="list_price">
                        <p class="price">￥${c.fruits.fruits_presentprice }</p>
                    </li>
                    <li class="list_amount">
                        <div class="amount_box">
                            <a href="javascript:;" class="reduce reSty">-</a>
                            <input type="text" value="${c.count }" class="sum">
                            <a href="javascript:;" class="plus">+</a>
                        </div>
                    </li>
                    <li class="list_sum">
                        <p class="sum_price">￥${c.fruits.fruits_presentprice }</p>
                    </li>
                    <li class="list_op">
                        <a href="${ctx }/cart/deletecart?cartId=${c.cartId}" class="delBtn" >移除商品</a>
                        <button type="submit"><a href="javascript:;" class="delBtn1" >立即购买</a></button>
                    </li>
                </ul>
             </c:forEach>  
             <button type="submit">立即购买</button>  
        </div>
        <!--底部-->
        <!-- <div class="bar-wrapper">
            <div class="bar-right">
                <div class="piece">已选商品<strong class="piece_num">0</strong>件</div>
                <div class="totalMoney">共计: <strong class="total_text">0.00</strong></div>
                <div class="calBtn"><a href="javascript:;">结算</a></div>
            </div>
        </div> -->
    </form>
</section>
<section class="model_bg"></section>
    
    <section class="my_model">
        <p class="title">删除宝贝<span class="closeModel">X</span></p>
        <p>您确认要删除该宝贝吗？</p>
        <div class="opBtn"><a href="" class="dialog-sure">确定</a><a href="javascript:;" class="dialog-close">关闭</a></div>
    </section>
    
</form>
    
	
    <script type="text/javascript" src="${ctx }/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx }/static/js/carts.js"></script>
<!-- 购物车主体结束 -->	
</body>
</html>
