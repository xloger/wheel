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
	 * 
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
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("p.jsp");
		rd.forward(req, resp);
	}
	
}
