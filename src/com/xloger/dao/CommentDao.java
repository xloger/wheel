package com.xloger.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.xloger.bean.CommentBean;
import com.xloger.bean.DbBean;

public class CommentDao {
	//添加评论，成功则返回相应ID（true），否则返回false
	public boolean addComment(CommentBean com){
		DbBean db=new DbBean();
		boolean i=false;
		try {
			i=db.insert("insert into wheel_comments(comment_post_ID,comment_author_ID,comment_content,comment_date,comment_status,comment_ip,comment_agent) values('"
					+ com.getPost_ID()
					+"','"
					+com.getAuthor_ID()
					+"','"
					+com.getContent()
					+"','"
					+com.getDate()
					+"','"
					+com.getStatus()
					+"','"
					+com.getIp()
					+"','"
					+com.getAgent()
					+ "')");
		} catch (Exception e) {
			System.out.println("添加回帖出错");
			e.printStackTrace();
		}
		
		return i;
	}
	
	//返回所有回帖，返回一个存贮所有回帖对象的List
	public List<CommentBean> showComment(int post_id){
		DbBean db=new DbBean();
		List<CommentBean> comlist=new ArrayList<CommentBean>();
		String sql="select * from wheel_comments where comment_post_ID="+post_id;
		try {
			ResultSet rs=db.query(sql);
			while(rs.next()){
				CommentBean com=new CommentBean();
				com.setID(rs.getInt(1));
				com.setPost_ID(rs.getInt(2));
				com.setAuthor_ID(rs.getInt(3));
				com.setContent(rs.getString(4));
				com.setDate(rs.getTimestamp(5));
				com.setStatus(rs.getInt(6));
				com.setIp(rs.getString(7));
				com.setAgent(rs.getString(8));
				comlist.add(com);
			}
		} catch (Exception e) {
			System.out.println("返回所有回帖出错");
			e.printStackTrace();
		}
		
		
		return comlist;
	}
}
