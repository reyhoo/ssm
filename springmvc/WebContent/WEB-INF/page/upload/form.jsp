<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<title>文件上传</title>
</head>
<body>
	<form action='<c:url value="/upload/uploadMultipartFile"></c:url>' method="post" enctype="multipart/form-data">
		<input type="file" name="file" value="请选择上传的文件"><br><br>
		<input type="text" name="name"><br><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>