package com.xloger.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xloger.bean.UserBean;
import com.xloger.dao.UserDao;
import com.xloger.tool.MyTool;


public class RegisterServlet extends HttpServlet{

	/**
	 * 处理注册表单的Servlet
	 */
	private static final long serialVersionUID = -1684962880754078008L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserDao udao=new UserDao();
		boolean jump=false; //判断跳转页面
		String message=""; //错误信息
		String name=req.getParameter("name");
		String psw1=req.getParameter("password1");
		String psw2=req.getParameter("password2");
		String email=req.getParameter("email");
		if(psw1.equals(psw2)){
			int i=udao.searchId(name);
			if(i==0){
				UserBean us=new UserBean();
				us.setName(name);
				us.setPassword(psw1);
				us.setEmail(email);
				us.setRegistertime(MyTool.getDate());
				us.setStatus(0);
				udao.addUser(us);
				jump=true;
			}else {
				message="用户已经存在";
			}
		}else {
			message="密码不一致";
		}
		
		RequestDispatcher rd;
		if (jump) {
			rd = req.getRequestDispatcher("index");
			rd.forward(req, resp);
		} else{
			req.setAttribute("message", message);
			rd = req.getRequestDispatcher("register.jsp");
			rd.forward(req, resp);
		}
	}

}
