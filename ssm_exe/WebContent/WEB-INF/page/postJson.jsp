<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>传递json参数</title>

<script type="text/javascript" src="/resource/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		var baseUrl = $("#baseUrl").val();
	//	alert(baseUrl);/*  */
		$("#findRoles").click(function(){
			request(baseUrl+"params/findRoles",JSON.stringify({roleName:"姚",note:"3",pageParams:{start:0,limit:90}}),"application/json");
		});
		$("#deleteRoles").click(function(){
			var data=[1,2,3,4];
			request(baseUrl+"params/deleteRoles",JSON.stringify(data),"application/json");
		});
		$("#addRoles").click(function(){
			var data=[
				{roleName:'tom',note:'tom note'},
				{roleName:'jerry',note:'jerry note'},
				{roleName:'姚磊',note:'姚磊 note'}
			];
			request(baseUrl+"params/addRoles",JSON.stringify(data),"application/json");
		});
		$("#commit").click(function(){
			request(baseUrl+"params/addRole1",$("form").serialize(),"application/x-www-form-urlencoded");
		});
	});
	
	function request(url,data,contentType){
		$.ajax({
			type:"POST" //GET POST
			,url:url//链接
			,data:data //POST请求的数据，可以为String或Object
			/*,dataType:"json"  */
			,contentType:contentType
			,beforeSend:function(xhr){
			
			//alert((typeof xhr)== 'object');
			}
			,success:function(response,statusTxt,xhr){
				alert(xhr.responseText)
				console.log(xhr.responseText);
			}
			,error:function(xhr){
				alert("status:"+xhr.status+"\nresponse:"+xhr.responseText);
			}
			});
	}
</script>
</head>
<body>
	<input type="hidden" id="baseUrl" value="<c:url value='/'></c:url>">
	<button id="findRoles">findRoles(sendJsonObject)</button><br><br>
	<button id="deleteRoles">deleteRoles(sendJsonArray)</button><br><br>
	<button id="addRoles">addRoles(sendJsonObjectArray)</button><br><br>
	<form id="addRoleForm">
		<input type="text" name="roleName">
		<input type="text" name="note">
		<input type="button" id="commit" value="增加">
	</form>
</body>
</html>