<%@page import="com.yl.springmvc.pojo.Role"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>角色详情</title>
</head>
<body>
<%
    Role role = (Role)request.getAttribute("role");
	System.err.println(role.getId());
	System.err.println(role.getRoleName());
	System.err.println(role.getNote());
%>
<table border="1">
	<tr>
	<td>标签
	<td>值
	<tr>
	<td>角色编号
	<td>${requestScope.role.id}

	<tr>
	<td>角色名称
	<td> <c:out value="${requestScope.role.roleName }"></c:out>
	<tr>
	<td>角色备注
	<td><c:out value="${role.note }"></c:out>
</table>
</body>
</html>