<%@page import="com.xloger.tool.MyTool"%>
<%@page import="com.xloger.function.IndexFunction"%>
<%@page import="com.xloger.bean.CommentBean"%>
<%@page import="com.xloger.bean.PostBean"%>
<%@page import="com.xloger.bean.UserBean"%>
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
<title>${po.getTitle()}</title>
<base href="<%=basePath%>">
<link rel="stylesheet" href="CSS/style.css">
</head>
<body>
<%@ include file = "header.jsp" %>

<p>发帖人：${po.getAuthor() }</p>
<pre>${po.getContent() }</pre>
<%
List<CommentBean> comlist=IndexFunction.showComment(((PostBean)request.getAttribute("po")).getID());
if(comlist==null||comlist.size()==0){
%>
	<p>没有回帖</p>
<%
}else {
	int i=0;
	while(i<comlist.size()){
		CommentBean com=comlist.get(i);
%>

	<p><%=com.getContent() %></p>
<%
	i++;
	}
}
%>


<% if(session.getAttribute("loginer")!=null){%>
	<form action="comment" method="post">
	<input type="hidden" name="post_id" value="${po.getID()}">
	<input type="hidden" name="author_id" value="${loginer.getID()}">
	<p>回帖内容：<input type="text" name="content"></p>
	<input type="submit" value="回帖">
	</form>
	
<% }else{ %>
	<p>请先登录再回帖</p>
<% } %>

<%@ include file = "bottom.jsp" %>
</body>
</html>