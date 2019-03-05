<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>validate</title>
</head>
<body>

	<form action='<c:url value="/validate/annotation"></c:url>' method="post">
		<table>
			<tr>
				<td>产品编号：
				<td><input name="productId" id="productId">
			<tr>
				<td>用户编号：
				<td><input name="userId" id="userId">
			<tr>
				<td>交易日期：
				<td><input name="date" id="date">
			<tr>
				<td>价格：
				<td><input name="price" id="price">
			<tr>
				<td>数量：
				<td><input name="quantity" id="quantity">
			<tr>
				<td>交易金额：
				<td><input name="amount" id="amount">
			<tr>
				<td>电子邮件：
				<td><input name="email" id="email">
			<tr>
				<td>备注：
				<td><textarea rows="5" cols="20" name="note" id="note"></textarea>
			<tr><td colspan="2" align="right"><input type="submit" value="提交">
		</table>
	</form>
</body>
</html>