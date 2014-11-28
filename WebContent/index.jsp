<%@page import="com.xloger.function.IndexFunction"%>
<%@page import="com.xloger.bean.PostBean"%>
<%@ page import="com.xloger.bean.UserBean"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<%@ include file = "header.jsp" %>


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
	<div class="posts">
	<a class="postname" href="p/<%=po.getID()%>"><%=po.getTitle() %></a>
	<span>作者：<%=po.getAuthor()%></span>
	<p>发布时间：<%=po.getDate() %></p>
	</div>
	<hr>
<%
	i++;
	}
}
%>

<%@ include file = "bottom.jsp" %>
</body>
</html>