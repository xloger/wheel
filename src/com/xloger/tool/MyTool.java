package com.xloger.tool;

public class MyTool {
	public static java.sql.Timestamp getDate(){
		java.util.Date  date=new java.util.Date();
		java.sql.Timestamp  datesql=new java.sql.Timestamp(date.getTime());
		return datesql;
	}
}
