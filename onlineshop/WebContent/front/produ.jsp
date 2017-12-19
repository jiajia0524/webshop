<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>全部产品</title>
    <link href="${ctx }/static/css/produ.css"rel="stylesheet">
    <link href="${ctx }/static/css/share.css"rel="stylesheet">
    <script src="${ctx }/static/js/jquery-1.12.3.js"></script>
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
                <li><a href="${ctx }/fruits/fruits_list2" style="color: #4AB344"><span style="color: #4AB344">全部产品</span></a> </li>
               <li><a href="#">${lu.userName }</a></li>
                <li><a href="${ctx }/front/login.jsp">退出登录</a> </li>
            </ul>
            <div class="sptopfoot">
                <div class="spbottom"  >
                </div>
            </div>
        </div>
         <div class="headr-right">
            
            <i class="iconfont" style="font-size: 16px;margin-right: 10px">&#xe7d5;</i><a href="${ctx }/cart/cartlist">
            我的购物车 ∨</a>
        </div>
    </div>
</div>
<!--顶部导航结束-->
<!--banner图片-->
<div class="her-banner">

</div>
<!--banner图片结束-->
<div class="content">
    <!--产品推荐开始-->
    <div class="recommand clear">
        <div class="rec-cont clear">
            <div class="rec-left">
                <div class="classily">
                    <div class="cltop">
                        <p>产品分类</p>
                    </div>
                    <div class="cltcon">
                        <p><a href="#">国产水果</a> </p>
                        <p><a href="#"> 进口水果</a></p>
                        <p style="border-bottom:0px dashed #999999;"><a href="#">新鲜时蔬</a></p>
                    </div>

                </div>
                <div class="service">
                    <div class="cltop">
                        <p>在线客服</p>
                    </div>
                    <div class="sercon">
                       <div class="qqs">
                           <p><a hidefocus="true" href="#">
                               <span class="serOnline-img0 qqImg0">&nbsp;</span>蜜桃
                           </a>
                           </p>
                           <P><a hidefocus="true" href="#">
                               <span class="serOnline-img0 qqImg0">&nbsp;</span>芒果
                           </a>
                           </P>
                       </div>
                        <div class="tims">
                            <div class="marBL-10">
                                <span class="worktime-header-img">&nbsp;</span>
                                <span class="serWorkTimeText"><b>工作时间</b></span>
                            </div>
                            <div class="serOnline-list-v "><span>周一至周五 ：8:30-17:30</span></div>
                            <div class="serOnline-list-v lastData"><span>周六至周日 ：9:00-17:00</span></div>
                        </div>
                    </div>

                </div>

            </div>
  <!-- 产品列表 -->
            <div class="rec-right">
                <div>
                    <form action="#" id="searchbox">
						<input type="text" placeholder="Search" />
					    <input type="submit" value="查询" background-color="blue"/>
				    </form>
                </div>
                <div class="bd">
                    <div class="bd1"  style="display: block">
                        <c:forEach items="${list }" var="f" begin="1" end="12">
                            <div class="rcr">
                            <div class="rcr-top">
                                <img src="${ctx }/static/images/${f.fruits_image}" width="100%">
                            </div>
                            <div class="rcr-bot">
                                <div class="rb-top">
                                    ${f.fruits_name }${f.fruits_count }
                                </div>
                                <div class="second_P">
                                    <span class="fk-prop">￥</span>
                                        <span class="fk-prop-price">${f.fruits_presentprice }0
                                            <span class="fk-prop-p"></span>
                                        </span>
                                    <span class="second_Marketprice">￥${f.fruits_originalprice }0</span>
                                </div>
                                <div class="buy">
                                    <a class="second_mallBuy"  href="fruitsDetail1.do?fruits_id=${f.fruits_id}">
                                        <span style="color: white;">购买</span>
                                    </a>
                                </div>
                            </div>
                        </div>   
                        </c:forEach> 
                       
                    </div>
                    <div class="bd1"  >
                        <c:forEach items="${list }" var="f" begin="12" end="23">
                            <div class="rcr">
                            <div class="rcr-top">
                                <img src="${ctx }/static/images/${f.fruits_image}" width="100%">
                            </div>
                            <div class="rcr-bot">
                                <div class="rb-top">
                                    ${f.fruits_name }${f.fruits_count }
                                </div>
                                <div class="second_P">
                                    <span class="fk-prop">￥</span>
                                        <span class="fk-prop-price">${f.fruits_presentprice }0
                                            <span class="fk-prop-p"></span>
                                        </span>
                                    <span class="second_Marketprice">￥${f.fruits_originalprice }0</span>
                                </div>
                                <div class="buy">
                                    <a class="second_mallBuy"  href="fruitsDetail1.do?fruits_id=${f.fruits_id}">
                                        <span style="color: white;">购买</span>
                                    </a>
                                </div>
                            </div>
                        </div>   
                        </c:forEach> 
                        
                            
                        
                    </div>
                    <div class="bd1">
                        <c:forEach items="${list }" var="f" begin="24" end="28">
                            <div class="rcr">
                            <div class="rcr-top">
                                <img src="${ctx }/static/images/${f.fruits_image}" width="100%">
                            </div>
                            <div class="rcr-bot">
                                <div class="rb-top">
                                    ${f.fruits_name }${f.fruits_count }
                                </div>
                                <div class="second_P">
                                    <span class="fk-prop">￥</span>
                                        <span class="fk-prop-price">${f.fruits_presentprice }0
                                            <span class="fk-prop-p"></span>
                                        </span>
                                    <span class="second_Marketprice">￥${f.fruits_originalprice }0</span>
                                </div>
                                <div class="buy">
                                    <a class="second_mallBuy"  href="fruitsDetail1.do?id=${f.fruits_id}">
                                        <span style="color: white;">购买</span>
                                    </a>
                                </div>
                            </div>
                        </div>   
                        </c:forEach> 
                    </div>
                </div>

                <div class="hd">
                    <div class="net">上一页</div>
                    <ul>
                        <li><a href="#" class="active">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                    </ul>
                    <div class="next"> 下一页</div>
                </div>
            </div>


        </div>
    </div>

    <!--产品推荐结束-->
</div>
<!--底部-->
<div class="footer">
    <div class="ft-con">
        <div class="ft-top">
            <img src="${ctx }/static/images/fot-1.jpg">
        </div>
        <div class="ft-bo">
            <div class="ft-b">
                <h3>服务保障</h3>
                <p>正品保证</p>
                <p>7天无理由退换</p>
                <p>退货返运费</p>
                <p>7X15小时客户服务</p>

            </div>
            <div class="ft-b">
                <h3>支付方式</h3>
                <p>公司转账</p>
                <p>货到付款</p>
                <p>在线支付</p>
                <p>分期付款</p>

            </div>
            <div class="ft-b">
                <h3>商家服务</h3>
                <p>商家入驻</p>
                <p>培训中心</p>
                <p>广告服务</p>
                <p>服务市场</p>

            </div>
            <div class="ft-b">
                <h3>服务保障</h3>
                <p>免运费</p>
                <p>海外配送</p>
                <p>EMS</p>
                <p>211限时达</p>

            </div>

        </div>
        <div class="banq">
            <p>©2016 果然新鲜 版权所有</p>
            <p>手机版 | 本站使用<span><img src="${ctx }/static/images/ft.jpg"></span>凡科建站搭建 | 管理登录</p>
        </div>

    </div>
</div>
</body>
<script src="${ctx }/static/js/produ.js"></script>
</html>