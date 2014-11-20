package com.xloger.tool;

import javax.servlet.http.HttpServletRequest;

public class MyTool {
	public static java.sql.Timestamp getDate(){
		java.util.Date  date=new java.util.Date();
		java.sql.Timestamp  datesql=new java.sql.Timestamp(date.getTime());
		return datesql;
	}
	
	public static String changeHTML(String value){
		value=value.replace("&", "&amp");
		value=value.replace(" ", "&nbsp");
		value=value.replace("<", "&lt");
		value=value.replace(">", "&gt");
		value=value.replace("\r\n", "<br>");
		return value;
	}
	
	public static String getUrlId(HttpServletRequest req){
		String s1=req.getContextPath()+req.getServletPath()+"/";
		String s2=req.getRequestURI();
		String s3=s2.replaceAll(s1, "");
		return s3;		
	}
}
