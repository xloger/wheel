package com.xloger.dao;

import java.sql.ResultSet;

import com.xloger.bean.DbBean;
import com.xloger.bean.UserBean;

public class UserDao {
	//查询是否有名为name的ID，有则返回此用户ID，否则返回0
	public int searchId(String name){
		DbBean db=new DbBean();
		try {
			ResultSet re=db.query("select * from wheel_users where user_name='"
					+name
					+"'");
			while(re.next()){
				return re.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("查找用户ID出错");
			e.printStackTrace();
		}
		return 0;
	}
	
	//添加用户，成功则返回用户ID（true），失败则返回false
	public boolean addUser(UserBean us){
		boolean i = false;
		try {
			DbBean db=new DbBean();
			i=db.insert("insert into wheel_users(user_name,user_password,user_email,user_registertime,user_status) values('"
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
		} catch (Exception e) {
			System.out.println("添加用户出错");
			e.printStackTrace();
		}
		return i;
	}
	
	//获取用户信息，成功则返回指定ID的用户对象，失败则返回null
	public UserBean getUser(String name){
		try {
			DbBean db=new DbBean();
			ResultSet re=db.query("select * from wheel_users where user_name='"
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
		} catch (Exception e) {
			System.out.println("获取用户出错");
			e.printStackTrace();
		}
		return null;		
	}
	
	
}
