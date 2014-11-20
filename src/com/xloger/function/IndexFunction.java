package com.xloger.function;

import java.util.List;

import com.xloger.bean.PostBean;
import com.xloger.dao.PostDao;

public class IndexFunction {
	public static List<PostBean> showPost(){
		PostDao pdao=new PostDao();
		List<PostBean> polist=pdao.showPost();
		return polist;
	}
}
