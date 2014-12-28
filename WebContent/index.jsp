<%@page import="com.xloger.bean.PostBean"%>
<%@ page import="com.xloger.bean.UserBean"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<jsp:include page="header.jsp" flush="true"/>


<%
//List<PostBean> polist=IndexFunction.showPost(); offsetTop
List<PostBean> polist=(List<PostBean>)request.getAttribute("polist");
if(polist==null||polist.size()==0){
%>
	<p style="text-align: center;">没有帖子</p>
<%
}else {
	int i=0;
	while(i<polist.size()){
		PostBean po=polist.get(i);
%>
	<div class="posts">
	<a class="postname" href="p/<%=po.getID()%>"><%=po.getTitle() %></a>
	<span>作者：<a href="user/<%=po.getAuthor().getID() %>"><%=po.getAuthor().getName() %></a></span>
	<p>发布时间：<%=po.getDate() %></p>
	</div>
	<hr>
<%
	i++;
	}
}
%>

<jsp:include page="bottom.jsp" flush="true"/>
</body>
</html>