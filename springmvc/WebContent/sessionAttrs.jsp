<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<p style="color: red;">${sessionScope.role.id }
	<p style="color: red;">${sessionScope.role.roleName }
	<p style="color: red;">${sessionScope.role.note }
	<p style="color: blue;">${sessionScope.id }
</body>
</html>