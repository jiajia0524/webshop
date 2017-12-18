<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link href="static/css/style.css" rel="stylesheet" type="text/css" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<title>添加蔬果</title>
</head>
<body>
     <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">添加蔬果</a></li>
    </ul>
    </div>
   
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    <form action="${ctx }/fruits/addfruits.do" method="post">
    <ul class="forminfo">
    <li><label>蔬果名字</label><input name="fruits_name" type="text" class="dfinput" /><i></i></li>
    <li><label>产地</label><input name="fruits_producingplace" type="text" class="dfinput"/><i></i></li>
    <li><label>单位</label><input name="fruits_count" type="text" class="dfinput" /></li>
    <li><label>现价</label><input name="fruits_presentprice" type="text" class="dfinput" /><i></i></li>
    <li><label>原价</label><input name="fruits_originalprice" type="text" class="dfinput" /><i></i></li>
    <li><label>类型</label><input name="type_id" type="text" class="dfinput"  /><i></i></li>
    <li><label>图片名字</label><input name="fruits_image" type="text" class="dfinput"/></li>
    <li><label>描述</label><input name="fruits_describe" cols="" rows="" type="text"></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </ul>
    </form>

    
    </div> 


  <!-- form action="${ctx }/fruits/addfruits.do" method="post">
        <table border="1px;">
                <tr>
                <td>蔬果编号</td>
                <td><input type="text" name="fruits_id"/></td>
            </tr>
            <tr>
                <td>蔬果名字</td>
                <td><input type="text" name="fruits_name"/></td>
            </tr>
            <tr>
                <td>产地</td>
                <td><input type="text" name="fruits_producingplace"/></td>
            </tr>
            <tr>
                <td>单位</td>
                <td><input type="text" name="fruits_count"/></td>
            </tr>
            <tr>
                <td>描述</td>
                <td><input type="text" name="fruits_describe"/></td>
            </tr>
            <tr>
                <td>现价</td>
                <td><input type="text" name="fruits_presentprice"/></td>
            </tr>
            <tr>
                <td>原价</td>
                <td><input type="text" name="fruits_originalprice"/></td>
            </tr>
            <tr>
                <td>类型</td>
                <td><input type="text" name="type_id"/></td>
            </tr>
            <tr>
                <td>图片名字</td>
                <td><input type="text" name="fruits_image"/></td>
            </tr>
            <tr>
                <td clos="2"><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>  -->

</body>
</html>