package com.xloger.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xloger.bean.DbBean;
import com.xloger.bean.UserBean;
import com.xloger.tool.MyTool;


public class RegisterServlet extends HttpServlet{

	/**
	 * 
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
		DbBean db=new DbBean();
		String name=req.getParameter("name");
		String psw1=req.getParameter("password1");
		String psw2=req.getParameter("password2");
		String email=req.getParameter("email");
		if(psw1.equals(psw2)){
			int i=db.searchNo(name);
			if(i==0){
				UserBean us=new UserBean();
				us.setName(name);
				us.setPassword(psw1);
				us.setEmail(email);
				us.setRegistertime(MyTool.getDate());
				us.setStatus(0);
				db.addUser(us);
			}else {
				System.out.println("用户已经存在");
			}
		}else {
			System.out.println("密码不一致");
		}
	}

}
