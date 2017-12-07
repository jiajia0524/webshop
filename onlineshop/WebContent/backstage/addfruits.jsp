<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="/onlineshop/fruits/addfruits" method="post">
        <table border="1">
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
    </form>

</body>
</html>