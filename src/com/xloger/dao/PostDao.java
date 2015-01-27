package com.xloger.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.xloger.bean.DbBean;
import com.xloger.bean.PostBean;

public class PostDao {
	//添加一个帖子，成功则返回帖子ID（true），失败则返回false
	public boolean addPost(PostBean po){
		DbBean db=new DbBean();
		boolean i=false;
		try {
			i=db.insert("insert into wheel_posts(post_author,post_title,post_content,post_date,post_status) values('"
						+ po.getAuthor().getID()
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
			System.out.println("添加帖子出错");
			e.printStackTrace();
		}
		return i;
	}
	
	//返回该uid的所有帖子，假如uid为0返回所有帖子。
	public List<PostBean> showPost(int uid){
		DbBean db=new DbBean();
		List<PostBean> postlist=new ArrayList<PostBean>();
		String sql;
		if(uid==0){
			sql="select * from wheel_posts";
		}else{
			sql="select * from wheel_posts where post_author ="+uid;
		}
		try {
			ResultSet rs=db.query(sql);
			while(rs.next()){
				PostBean po=new PostBean();
				po.setID(rs.getInt(1));
				po.setAuthor(rs.getString(2));
				po.setTitle(rs.getString(3));
				po.setContent(rs.getString(4));
				po.setDate(rs.getTimestamp(5));
				po.setStatus(rs.getInt(6));
				postlist.add(po);
			}
		} catch (Exception e) {
			System.out.println("返回所有帖子出错");
			e.printStackTrace();
		}
		
		
		return postlist;
	}
	
	//返回指定部分的帖子列表
	public List<PostBean> showPost(int begin,int num){
		DbBean db=new DbBean();
		List<PostBean> postlist=new ArrayList<PostBean>();
		String sql;
		sql="select * from wheel_posts where post_status =1 limit "+num+" offset "+begin;
		try {
			ResultSet rs=db.query(sql);
			while(rs.next()){
				PostBean po=new PostBean();
				po.setID(rs.getInt(1));
				po.setAuthor(rs.getString(2));
				po.setTitle(rs.getString(3));
				po.setContent(rs.getString(4));
				po.setDate(rs.getTimestamp(5));
				po.setStatus(rs.getInt(6));
				postlist.add(po);
			}
		} catch (Exception e) {
			System.out.println("返回指定部分帖子出错");
			e.printStackTrace();
		}
		
		
		return postlist;
	}
	
	//获取指定ID的帖子信息，成功返回指定ID的对象，失败则返回null
	public PostBean getPost(int id){
		DbBean db=new DbBean();
		try {
			ResultSet re=db.query("select * from wheel_posts where ID='"
					+id
					+"'");
			while(re.next()){
				PostBean po=new PostBean();
				po.setID(re.getInt(1));
				po.setAuthor(re.getString(2));
				po.setTitle(re.getString(3));
				po.setContent(re.getString(4));
				po.setDate(re.getTimestamp(5));
				po.setStatus(re.getInt(6));
				return po;
			}
		} catch (Exception e) {
			System.out.println("获取帖子信息出错");
			e.printStackTrace();
		}
		return null;
	}
	
	//返回现有帖子的数量
	public int showNum(){
		DbBean db=new DbBean();
		try {
			ResultSet re=db.query("select * from wheel_posts where post_status = 1");
			boolean b=re.last(); //把re指到最后，然后获取该行的编号
			if(b==true){
				//=。=只是为了消除b未引用的报错
			}
			return re.getRow();
		} catch (Exception e) {
			System.out.println("显示帖子数量出错");
			e.printStackTrace();
		}
		return 0;
	}
}
