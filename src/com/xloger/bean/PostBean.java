package com.xloger.bean;

import com.xloger.tool.MyTool;

public class PostBean {
	private int ID;
	private String author;
	private String title;
	private String content;
	private java.sql.Timestamp date;
	private int status;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = MyTool.changeHTML(title);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = MyTool.changeHTML(content);
	}
	public java.sql.Timestamp getDate() {
		return date;
	}
	public void setDate(java.sql.Timestamp date) {
		this.date = date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
