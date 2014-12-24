package com.xloger.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xloger.bean.CommentBean;
import com.xloger.dao.CommentDao;
import com.xloger.tool.MyTool;

public class CommentServlet extends HttpServlet{

	/**
	 * 处理回帖表单的Servlet
	 */
	private static final long serialVersionUID = 7586838524910497722L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		CommentDao comdao=new CommentDao();
		String content=req.getParameter("content");
		int post_id=Integer.parseInt(req.getParameter("post_id"));
		int author_id=Integer.parseInt(req.getParameter("author_id"));
		
		CommentBean com=new CommentBean();
		com.setPost_ID(post_id);
		com.setAuthor_ID(author_id);
		com.setContent(content);
		com.setDate(MyTool.getDate());
		com.setStatus(1);
		com.setIp(MyTool.getRemortIP(req));
		com.setAgent(req.getHeader("user-agent"));

		
		boolean i=comdao.addComment(com);
		if(i){
			resp.sendRedirect("p/"+com.getPost_ID());
		}
	}
	
}
