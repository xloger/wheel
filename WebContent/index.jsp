<%@page import="com.xloger.function.IndexFunction"%>
<%@page import="com.xloger.bean.PostBean"%>
<%@ page import="com.xloger.bean.UserBean"%>
<%@ page import="java.util.List"%>
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
<title>首页</title>
<base href="<%=basePath%>">
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

<%
List<PostBean> polist=IndexFunction.showPost();
if(polist==null||polist.size()==0){
%>
	<p>没有帖子</p>
<%
}else {
	int i=0;
	while(i<polist.size()){
		PostBean po=polist.get(i);
%>
	<p><a href="p/<%=po.getID() %>"><%=po.getTitle() %></a></p>
<%
	i++;
	}
}
%>

</body>
</html>