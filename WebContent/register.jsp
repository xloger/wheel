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
<title>注册</title>
</head>
<body>
<p><a href="index.jsp">返回</a></p>
<form action="register" method="post">
用户名：<input type="text" name="name">
<br>
密码：<input type="password" name="password1">
<br>
再次输入密码：<input type="password" name="password2">
<br>
Email:<input type="text" name="email">
<br>
<input type="submit" value="注册">
</form>
</body>
</html>