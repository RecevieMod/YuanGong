package filter;

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

public class FilterServletDemo implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//把ServletRequest转换成HttpServletRequest
		HttpServletRequest req = (HttpServletRequest)request;
		//获得Session
		HttpSession session = req.getSession();
		//从Session中获取userid
		String value = (String)session.getAttribute("userid");
		
		if(value!=""&&value!=null){
			//对该用户进行放行操作
			chain.doFilter(request, response);
			
		}else{
			//不满足条件，跳转到登录界面
			HttpServletResponse resp=(HttpServletResponse)response;
			//获得根目录
			String rpath=req.getContextPath();
			resp.sendRedirect(rpath+"/DengLu.html");
			//request.getRequestDispatcher("DengLu.html").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
