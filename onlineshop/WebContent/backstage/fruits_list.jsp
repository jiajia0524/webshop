<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>水果列表</title>
</head>
<body>
   <table border="1px">
    <tr>
        <th>蔬果编号</th>
        <th>蔬果名字</th>
        <th>产地</th>
        <th>单位</th>
        <th>描述</th>
        <th>现价</th>
        <th>原价</th>
        <th>类型</th>
        <th>参考图片</th>
        <td>加入购物车</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list }" var="f">
    <tr>
        <td>${f.fruits_id }</td>
        <td>${f.fruits_name }</td>
        <td>${f.fruits_producingplace }</td>
        <td>${f.fruits_count }</td>
        <td>${f.fruits_describe }</td>
        <td>${f.fruits_presentprice }</td>
        <td>${f.fruits_originalprice }</td>
        <td>${f.type_id }</td>
        <td>${f.fruits_image }</td>
        <td>
        <a href="">加入购物车</a>
      </td>
      <td>
        <a href="fruitsDetail.do?id=${f.fruits_id}">详情</a>&nbsp;||&nbsp;
        <a href="preupdatebook.do?id=${b.id}">修改</a>&nbsp;||&nbsp;
        <a href="deletebook.do?id=${b.id}">删除</a>
      </td>
    </tr>
    </c:forEach>
</table>
    <br>共${list.totalcount }条记录共${totalpage }页&nbsp;&nbsp;当前第${dpage }页&nbsp;&nbsp;
            <a href="${ctx }/select.do?page=1">首页</a>&nbsp;&nbsp;
            <c:if test="${page.dpage!=-1 }">
            <a href="${ctx }/select.do?page=${page.dpage-1}">下一页</a>&nbsp;&nbsp;
            </c:if>
            <c:if test="${page.dpage!=page.totalpage }">
            <a href="${ctx }/select.do?page=${page.dpage+1}">上一页</a>&nbsp;&nbsp;
            </c:if>
            <a href="${ctx }/select.do?page=${page.totalpage}">上一页">尾页</a>&nbsp;&nbsp;
    

</body>
</html>