<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>设置sessionAttr</title>
</head>
<body>

	<%session.setAttribute("testRoleId", 18l);
	response.sendRedirect("/ssm_exe/attribute/sessionAttr");
	%>
</body>
</html>