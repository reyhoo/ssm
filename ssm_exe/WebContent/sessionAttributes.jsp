<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>设置sessionAttr</title>
</head>
<body>

	${sessionScope.loginRole.id } <br>
	${sessionScope.loginRole.roleName }<br>
	${sessionScope.loginRole.note }<br><br><br>
	
	${sessionScope.roleName }
</body>
</html>