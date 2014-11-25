package com.xloger.function;

import java.util.List;

import com.xloger.bean.CommentBean;
import com.xloger.bean.PostBean;
import com.xloger.dao.CommentDao;
import com.xloger.dao.PostDao;

public class IndexFunction {
	public static List<PostBean> showPost(){
		PostDao pdao=new PostDao();
		List<PostBean> polist=pdao.showPost();
		return polist;
	}
	
	public static List<CommentBean> showComment(int post_id){
		CommentDao comdao=new CommentDao();
		List<CommentBean> comlist=comdao.showComment(post_id);
		return comlist;
	}
}
