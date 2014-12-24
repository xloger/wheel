package com.xloger.tool;

import javax.servlet.http.HttpServletRequest;

public class MyTool {
	//获得数据库格式的当前时间
	public static java.sql.Timestamp getDate(){
		java.util.Date  date=new java.util.Date();
		java.sql.Timestamp  datesql=new java.sql.Timestamp(date.getTime());
		return datesql;
	}
	
	//HTML标签转义
	public static String changeHTML(String value){
		value=value.replace("&", "&amp;");
		value=value.replace(" ", "&nbsp;");
		value=value.replace("<", "&lt;");
		value=value.replace(">", "&gt;");
		value=value.replace("\r\n", "<br>");
		return value;
	}
	
	//获取当前帖子页面的帖子ID
	public static String getUrlId(HttpServletRequest req){
		String s1=req.getContextPath()+req.getServletPath()+"/";
		String s2=req.getRequestURI();
		String s3=s2.replaceAll(s1, "");
		return s3;
	}
	
	//获取真实的IP
	public static String getRemortIP(HttpServletRequest request) { 
		if (request.getHeader("x-forwarded-for") == null) { 
		return request.getRemoteAddr(); 
		} 
		return request.getHeader("x-forwarded-for"); 
	} 
}
