<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件上传</title>
</head>
<body>
	
	<form action="<c:url value='/upload/toUpload2'></c:url>" method="post" enctype="multipart/form-data">
		<input type="file" name="f"><br><br>
		<input type="text" name="name"><br><br>
		<input type="submit" value="上传">
		
	</form>
</body>
</html>