<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
// 获得项目完全路径
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>注册</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<%@ include file = "header.jsp" %>


<form action="register" method="post" id="resform"  autocomplete="on">
<h2>注册</h2>
<spean>请输入用户名：</spean> <input type="text" name="name" required="required" pattern="^[a-zA-Z0-9_]{6,16}" oninvalid="setCustomValidity('请输入由字母和数字组合的，长度在6-16位的用户名')">
<br>
<spean>请输入密码：</spean> <input type="password" name="password1" required="required" pattern="^[a-zA-Z][a-zA-Z0-9]{5,15}" oninvalid="setCustomValidity('请输入由字母和数字组合的，长度在6-16位的密码')">
<br>
<spean>再次输入密码：</spean> <input type="password" name="password2" required="required" pattern="^[a-zA-Z][a-zA-Z0-9]{5,15}" oninvalid="setCustomValidity('请输入由字母和数字组合的，长度在6-16位的密码')">
<br>
<spean>请输入Email:</spean> <input type="email" name="email" required="required">
<br>
<br>
<input type="reset" value="重置"/> 
<input type="submit" value="注册">
</form>

<%@ include file = "bottom.jsp" %>
</body>
</html>