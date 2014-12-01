package com.xloger.bean;

import com.xloger.tool.BrowseTool;
import com.xloger.tool.MyTool;

public class CommentBean {
	private int ID;
	private int post_ID;
	private int author_ID;
	private String content;
	private java.sql.Timestamp date;
	private int status;
	private String ip;
	private String agent;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getPost_ID() {
		return post_ID;
	}
	public void setPost_ID(int post_ID) {
		this.post_ID = post_ID;
	}
	public int getAuthor_ID() {
		return author_ID;
	}
	public void setAuthor_ID(int author_ID) {
		this.author_ID = author_ID;
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getAgent() {
		return BrowseTool.checkBrowse(agent);
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	
}
