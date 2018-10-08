package ecjtu.cloud_note.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object obj, Exception exception)
			throws Exception {
		
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object obj) throws Exception {
		HttpSession session = req.getSession();
		Object user = session.getAttribute("user");
		System.out.println("user"+user);
		//没有登录,跳转到登录页面
		if (user == null) {
			resp.sendRedirect("/cloud_note/log_in.html");
			//System.out.println("user==null");
			return false;
		}
		//已经登录,继续执行
		//System.out.println("user != null");
		return true;
	}

}
