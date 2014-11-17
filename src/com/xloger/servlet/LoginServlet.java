package com.xloger.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xloger.bean.UserBean;
import com.xloger.dao.UserDao;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7942557820347166894L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserDao udao=new UserDao();
		UserBean us=new UserBean();
		int jump=0; //判断跳转页面
		String name=req.getParameter("name");
		String psw=req.getParameter("password");
		us=udao.getUser(name);
		if(us!=null){
			if(us.getPassword().equals(psw)){
				jump=1;
			}else{
				System.out.println("密码不一致");
				jump=2;
			}
		}else {
			System.out.println("用户不存在");
			jump=3;
		}
		
		RequestDispatcher rd;
		if (jump==1) {
			rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		} else if(jump==2){
			rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		} else if(jump==3){
			rd = req.getRequestDispatcher("register.jsp");
			rd.forward(req, resp);
		}
	}

}
