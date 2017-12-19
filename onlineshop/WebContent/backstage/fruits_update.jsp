<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="body">
<form action="updatefruits.do" method="post">
	<div class="left">
	  <img src="${ctx }/static/images/${f.fruits_image}" alt="封面" />
	</div>
	<div class="right">
	  
		  <table border="1px">
		  <tr height="50px">
		      <td width="100px">id</td>
		      <td width="200px"><input type="text" name="id"  value="${f.fruits_id}"/></td>
		    </tr>
		    <tr height="50px">
		      <td width="100px">书名</td>
		      <td width="200px"><input type="text" name="name"  value="${f.fruits_name}"/></td>
		    </tr>
		    <tr height="50px">
		      <td width="100px">类别</td>
		      <td width="200px"><input type="text" name="typeid" value="${f.fruitstype_id}"/></td>
		    </tr>
		    <tr height="50px">
		      <td width="100px">封面</td>
		      <td width="200px"><input type="text" name="image" value="${f.fruits_image}"/></td>
		    </tr>
		    <tr height="50px">
		      <td width="100px">价格</td>
		      <td width="200px"><input type="text" name="price" value="${f.fruits_presentprice}"/></td>
		    </tr>
		    <tr>
			    <td style="text-align:right;"></td>
			    <td><input type="submit" value="保存"/></td>
		   	</tr>
		  </table>
	 
	  
	</div>
</form>
</div>
<form action="bookimg.do?id=${book.id}" method="post" enctype="multipart/form-data">
	    <input type="file" name="file"/>
	    <input type="submit" />
</form>
</body>
</html>