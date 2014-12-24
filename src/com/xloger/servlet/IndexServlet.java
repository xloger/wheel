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
		List<PostBean> polist=pdao.showPost();
		req.setAttribute("polist", polist);
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);

	}
	
}
