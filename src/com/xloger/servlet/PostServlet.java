package com.xloger.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xloger.bean.PostBean;
import com.xloger.bean.UserBean;
import com.xloger.dao.PostDao;
import com.xloger.tool.MyTool;

public class PostServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5360898663819585210L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action=req.getParameter("action");
		if(action.equals("add")){
			this.add(req, resp);
		}else if(action.equals("del")){
			this.del(req, resp);
		}
	}
	private void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session=req.getSession();
		PostDao pdao=new PostDao();
		PostBean po=new PostBean();
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		po.setTitle(title);
		po.setContent(content);
		po.setAuthor(((UserBean)session.getAttribute("loginer")).getName());
		po.setDate(MyTool.getDate());
		po.setStatus(1);
		boolean i=pdao.addPost(po);
		RequestDispatcher rd;
		if (i==true) {
			rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
		
		
	}
	private void del(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	
}