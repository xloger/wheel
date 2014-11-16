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
	private static ResultSet re;
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
	public int searchNo(String name){
		conn=this.getConnection();
		try {
			st=conn.createStatement();
			re=st.executeQuery("select * from wheel_users where user_name='"
					+name
					+"'");
			while(re.next()){
				return re.getInt(1);
			}
		
		} catch (SQLException e) {
			System.out.println("查找用户名出错");
			e.printStackTrace();
		}
		return 0;
	}
	public int addUser(UserBean us){
		conn=this.getConnection();
		try {
			st=conn.createStatement();
			int i=st.executeUpdate("insert into wheel_users(user_name,user_password,user_email,user_registertime,user_status) values('"
					+ us.getName()
					+"','"
					+us.getPassword()
					+"','"
					+us.getEmail()
					+"','"
					+us.getRegistertime()
					+"','"
					+us.getStatus()
					+ "')");
			return i;
		} catch (SQLException e) {
			System.out.println("添加用户出错");
			e.printStackTrace();
		}
		
		return 0;		
	}
	
	public UserBean getUser(String name){
		conn=this.getConnection();
		try {
			st=conn.createStatement();
			re=st.executeQuery("select * from wheel_users where user_name='"
					+name
					+"'");
			while(re.next()){
				UserBean us=new UserBean();
				us.setID(re.getInt(1));
				us.setName(re.getString(2));
				us.setPassword(re.getString(3));
				us.setNicename(re.getString(4));
				us.setEmail(re.getString(5));
				us.setImage(re.getString(6));
				us.setRegistertime(re.getTimestamp(7));
				us.setStatus(re.getInt(8));
				return us;
			}
		} catch (SQLException e) {
			System.out.println("获取用户出错");
			e.printStackTrace();
		}
		return null;		
	}

}
