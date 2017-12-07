<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>蔬果信息</title>
</head>
<%
    //获取请求上下文
    String context = request.getContextPath();
%>
<body>
    <div style="margin-left:100px; margin-top:100px;">
        <div>
            <form action="" id="fFrom" method="post">
                                姓名
                <input type="text" name="fruits_name" id="fruits_name" style="width:120px"/>
                &nbsp;
                                 类型
                <select name="type_id" id="type_id" style="width:80px">
                    <option value="1">国产水果</option>
                    <option value="2">进口水果</option>
                    <option value="3">新鲜时蔬</option>
                </select>
                <input type="submit" value="查询"/> 
            </form>
        </div>
        <br>
        信息列表：<br>
        <br>
        <!-- 后台返回结果为空 -->
            <c:if test="${fn:length(result.dataList)eq 0 }">
                <span>查询结果为空</span>
            </c:if>
        <!-- 后台返回结果不为空 -->
            <c:if test="${fn:length(result.dataList)gt 0 }">
                <table border="1px" cellspacing="0px" style="border-collapse:collapse">
            <thead>
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
                </tr>
            </thead>
                <c:forEach items="${result.dataList }">
                    <tr>
                        <td><c:out value="${fruits.fruits_id }"></c:out></td>
                        <td><c:out value="${fruits.fruits_name }"></c:out></td>
                        <td><c:out value="${fruits.fruits_producingplace }"></c:out></td>
                        <td><c:out value="${fruits.fruits_count}"></c:out></td>
                        <td><c:out value="${fruits.fruits_describe}"></c:out></td>
                        <td><c:out value="${fruits.fruits_presentprice }"></c:out></td>
                        <td><c:out value="${fruits.fruits_originalprice }"></c:out></td>
                        <td>
                            <c:if test="${fruits.type_id eq 1 }">国产水果</c:if>
                            <c:if test="${fruits.type_id eq 2 }">进口水果</c:if>
                            <c:if test="${fruits.type_id eq 3 }">新鲜时蔬</c:if>
                        </td>
                        <td><c:out value="${fruits.fruits_image }"></c:out></td>
                        
                    </tr>
                </c:forEach>
            </table>
            <br>共条记录共页&nbsp;&nbsp;当前第页&nbsp;&nbsp;
            <a href="">首页</a>&nbsp;&nbsp;
            <a href="">下一页</a>&nbsp;&nbsp;
            <a href="">上一页</a>&nbsp;&nbsp;
            <a href="">尾页</a>&nbsp;&nbsp;
        </c:if>
    </div>

</body>
</html>