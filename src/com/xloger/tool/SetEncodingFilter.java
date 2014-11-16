package com.xloger.tool;

import javax.servlet.*;
import java.io.*;

public class SetEncodingFilter implements Filter {
	protected String encoding = null;// 定义缺省字符编码方式
	protected boolean ignore = true;// 定义客户端指定的编码方式是否应被忽略
	protected FilterConfig filterConfig = null;// 定义过滤器配置对象,若为null,则说明过滤器未配置

	public void destroy()// 停止过滤器的工作
	{
		this.encoding = null;
		this.filterConfig = null;
	}

	// 设置字符编码
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		if (ignore || (req.getCharacterEncoding() == null)) {
			req.setCharacterEncoding(selectEncoding(req));
		}
		chain.doFilter(req, res);
	}

	// 启动过滤器
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
		String value = filterConfig.getInitParameter("ignore");
		if (value == null)
			this.ignore = true;
		else if (value.equalsIgnoreCase("true")
				|| value.equalsIgnoreCase("yes"))
			this.ignore = true;
		else
			this.ignore = false;
	}

	// 选择合适的字符编码方式
	protected String selectEncoding(ServletRequest req) {
		return this.encoding;
	}

	// 返回filterConfig对象
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	// 设置filterConfig对象
	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}
	
	
//	private String encoding = "UTF-8";  
//    protected FilterConfig filterConfig;  
//      
//      
//    public void init(FilterConfig filterConfig) throws ServletException {  
//        this.filterConfig = filterConfig;  
//        //本过滤器默认编码是UTF-8，但也可以在web.xml配置文件里设置自己需要的编码  
//        if(filterConfig.getInitParameter("encoding") != null)  
//            encoding = filterConfig.getInitParameter("encoding");  
//    }  
//  
//    public void doFilter(ServletRequest srequset, ServletResponse sresponse,  
//            FilterChain filterChain) throws IOException, ServletException {  
//        HttpServletRequest request = (HttpServletRequest)srequset;  
//        request.setCharacterEncoding(encoding);  
//        filterChain.doFilter(srequset, sresponse);  
//    }  
//      
//    public void destroy() {  
//        this.encoding = null;  
//    }
}