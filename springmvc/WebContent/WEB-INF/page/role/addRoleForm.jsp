<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加角色</title>
</head>
<body>


	 <form style="width: 50%;"  action="<c:url value='/params/requestParam'></c:url>" method="post">
	 	<fieldset>
	 		<legend>添加角色</legend>
	 			<span>角色名称</span><input type="text" name="roleName"><br>
	 	<span>备注</span><input type="text" name="note"><br>
	 	<span><input type="submit" value="提交"></span>
	 	</fieldset>
	 
	 </form>
</body>
</html>