<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.xloger.bean.UserBean"%>

<div class="center">
            <div class="top">
            <a href="index.jsp">logo</a>           
                <% 
				if(session.getAttribute("loginer")==null){ %>
                	<a href="login.jsp" class="topbutton">马上登陆</a>
					<a href="register.jsp" class="topbutton">立即注册</a>
				<% }else{ %>
					<div id="welcome">
					您好，用户<% out.print( ((UserBean)session.getAttribute("loginer")).getName() );%>
					<br>
					<a href="post.jsp">发帖</a>&nbsp;&nbsp;
					<a href="login?action=logout">注销</a>
					</div>
				<% } %>
                
            </div>
            <div class="content">