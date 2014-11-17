package com.xloger.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbBean {
	private static String url="jdbc:mysql://localhost:3306/wheel?characterEncoding=UTF-8";
	private static String user="root";
	private static String password="xielong";
	private static Connection conn;
	private static Statement st;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动出错");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		try {
			conn = (Connection)DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			System.out.println("连接数据库出错");
			e.printStackTrace();
			return null;
		}

	}
	
	//增
	public boolean insert(String sql) throws Exception{
		getConnection();
		st=conn.createStatement();
		if(st.executeUpdate(sql)==1){
			return true;
		}else{			
			return false;		
		}
	}
	
	//删
	public void delete(String sql) throws Exception{
		getConnection();
		st=conn.createStatement();
		st.executeUpdate(sql);
	}
	
	//改
	public void update(String sql) throws Exception{
		getConnection();
		st=conn.createStatement();
		st.executeUpdate(sql);
	}
	
	//查
	public ResultSet query(String sql) throws Exception{
		getConnection();
		st=conn.createStatement();
		return st.executeQuery(sql);	
	}
	


}
