<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加角色</title>
</head>
<body>

<form action="<c:url value='/params/addRole3'></c:url>" method="post">
	角色名称 <input type="text" name="roleName"><br><br>
	备注<input type="text" name="note"><br><br>
	<input type="submit" value="增加">
</form>

</body>
</html>