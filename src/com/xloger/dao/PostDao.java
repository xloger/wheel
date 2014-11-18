package com.xloger.dao;

import com.xloger.bean.DbBean;
import com.xloger.bean.PostBean;

public class PostDao {
	public boolean addPost(PostBean po){
		DbBean db=new DbBean();
		boolean i=false;
		try {
			i=db.insert("insert into wheel_posts(post_author,post_title,post_content,post_date,post_status) values('"
						+ po.getAuthor()
						+"','"
						+po.getTitle()
						+"','"
						+po.getContent()
						+"','"
						+po.getDate()
						+"','"
						+po.getStatus()
						+ "')");
		} catch (Exception e) {
			System.out.println("添加文章出错");
			e.printStackTrace();
		}
		return i;
	}
}
