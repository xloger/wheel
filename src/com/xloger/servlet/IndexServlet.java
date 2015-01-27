package com.xloger.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xloger.bean.PostBean;
import com.xloger.dao.PostDao;

public class IndexServlet extends HttpServlet{

	/**
	 * 显示首页所有帖子
	 */
	private static final long serialVersionUID = -4933562409391193497L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PostDao pdao=new PostDao();
		int page=5; //一页显示多少帖子
		int pagesum; //一共多少页
		int pagenow=1; //当前页
		//计算要用多少页
		int pNum=pdao.showNum();
		int tempyu=pNum%page;
		if(tempyu==0){
			pagesum=pNum/page;
		}else {
			pagesum=pNum/page+1;
		}

		if(req.getParameter("jumppage")!=null&&!"".equals(req.getParameter("jumppage"))){
			pagenow=Integer.parseInt(req.getParameter("jumppage"));
		}
		
		List<PostBean> polist=pdao.showPost((pagenow-1)*page,page);
		req.setAttribute("polist", polist);
		req.setAttribute("pagesum", pagesum);
		req.setAttribute("pagenow", pagenow);
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);

	}
	
}
