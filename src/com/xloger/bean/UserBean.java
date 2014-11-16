package com.xloger.bean;

public class UserBean {
	private int ID;
	private String name;
	private String password;
	private String nicename;
	private String email;
	private String image;
	private java.sql.Timestamp registertime;
	private int status;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNicename() {
		return nicename;
	}
	public void setNicename(String nicename) {
		this.nicename = nicename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public java.sql.Timestamp getRegistertime() {
		return registertime;
	}
	public void setRegistertime(java.sql.Timestamp registertime) {
		this.registertime = registertime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
