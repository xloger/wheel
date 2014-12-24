package com.xloger.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xloger.bean.PostBean;
import com.xloger.dao.PostDao;
import com.xloger.tool.MyTool;

public class PServlet extends HttpServlet{

	/**
	 * 通过获取帖子网址来载入帖子内容，将帖子信息存入“po”的req，并转发到实现页面“/p.jsp”
	 */
	private static final long serialVersionUID = -1337257924004998983L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PostDao pdao=new PostDao();
		int pid=Integer.parseInt(MyTool.getUrlId(req));
		PostBean po=pdao.getPost(pid);

		req.setAttribute("po", po);
		
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("/p.jsp");
		rd.forward(req, resp);
	}
	
}
