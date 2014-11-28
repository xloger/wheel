<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
// 获得项目完全路径
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>登陆</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<%@ include file = "header.jsp" %>

<form action="login?action=login" method="post" id="loginform">
<h2>登陆</h2>
用户：<input type="text" name="name">
<br>
密码：<input type="password" name="password">
<br>
<br>
<input type="reset" value="重置">
<input type="submit" value="登陆">
</form>

<%@ include file = "bottom.jsp" %>
</body>
</html>