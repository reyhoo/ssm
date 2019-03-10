<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>角色列表</title>
</head>
<body>
	<table>
		<tr>
		<td>角色编号
		<td>角色名称
		<td>备注
		<c:forEach items="${requestScope.roleList }" var="role">
			<tr>
		<td>${role.id }
		<td>${role.roleName }
		<td>${role.note }
		</c:forEach>
	</table>
</body>
</html>