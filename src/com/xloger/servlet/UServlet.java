package com.xloger.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xloger.bean.PostBean;
import com.xloger.bean.UserBean;
import com.xloger.dao.PostDao;
import com.xloger.dao.UserDao;
import com.xloger.tool.MyTool;

public class UServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8797169169751598096L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int uid=Integer.parseInt(MyTool.getUrlId(req));
		UserDao udao=new UserDao();
		PostDao pdao=new PostDao();
		
		UserBean us=udao.getUser(uid);
		req.setAttribute("userpage_userinfo", us);
		
		List<PostBean> userlist=pdao.showPost(uid);
		req.setAttribute("userpage_userlist", userlist);
		
		
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("/u.jsp");
		rd.forward(req, resp);
	}

}
