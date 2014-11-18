<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.xloger.bean.UserBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
<% 
if(session.getAttribute("loginer")==null){ %>
<p><a href="register.jsp">注册</a></p>
<p><a href="login.jsp">登陆</a></p>
<% }else{ %>
<p>您好，用户<% out.print( ((UserBean)session.getAttribute("loginer")).getName() );%></p>
<p><a href="post.jsp">发帖</a></p>
<p><a href="login?action=logout">注销</a></p>
<% } %>
</body>
</html>