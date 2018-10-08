package ecjtu.cloud_note.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//转换req,resp
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		//列出不需要过滤的请求
		String[] paths = {"/log_in.html","/user/login.do","/user/add.do","/edit.html"};
		//获得当前路径
		String path = request.getServletPath();
		for(String p : paths) {
			if (p.equals(path)) {
				//不必过滤,请求继续执行
				chain.doFilter(request, response);
				return;
			}
		}
		//获得session
		HttpSession session = request.getSession();
		//从session中尝试获取账号
		String adminCode = (String) session.getAttribute("userName");
		
		//根据账号判断用户判断是否登录
		if(adminCode == null) {
			//未登录，重定向到登录页
			response.sendRedirect("/cloud_note/user/login.do");
		}else {
			//已登录，请求继续执行
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
