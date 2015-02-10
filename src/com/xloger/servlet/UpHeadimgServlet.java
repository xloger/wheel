package com.xloger.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.xloger.bean.UserBean;
import com.xloger.dao.UserDao;



public class UpHeadimgServlet extends HttpServlet{

	/**
	 * 实现上传头像的功能
	 */
	private static final long serialVersionUID = -4808314419848618014L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload sfu=new ServletFileUpload(factory);
		sfu.setFileSizeMax(2*1024*1024);
		
		try {
			List<FileItem> items=sfu.parseRequest(req);
			for(int i=0;i<items.size();i++){
				FileItem item=items.get(i);
				if(!item.isFormField()){
					ServletContext sctx=getServletContext();
					String path=sctx.getRealPath("/images/headimg");
					
					String filename=item.getName();
					filename=filename.substring(filename.lastIndexOf('\\')+1);
					filename=filename.substring(filename.lastIndexOf('.'));
					HttpSession session=req.getSession();
					filename=Integer.toString(((UserBean)session.getAttribute("loginer")).getID())+filename;//把存入文件名设为用户ID
					File file=new File(path+"\\"+filename);
					
					
					item.write(file);
						
					//把头像路径存入数据库
					UserBean uploader=(UserBean) session.getAttribute("loginer");
					uploader.setImage("images/headimg/"+filename);
					UserDao udao=new UserDao();
					udao.updateUser(uploader);
						
					resp.sendRedirect("index");
					
					
					
				}
			}
			
			
		} catch (FileUploadException e) {
			System.out.println("获取form列表出错");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("write文件出错");
			e.printStackTrace();
		}
	}
	
}
