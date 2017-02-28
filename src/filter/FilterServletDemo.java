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
		//��ServletRequestת����HttpServletRequest
		HttpServletRequest req = (HttpServletRequest)request;
		//���Session
		HttpSession session = req.getSession();
		//��Session�л�ȡuserid
		String value = (String)session.getAttribute("userid");
		
		if(value!=""&&value!=null){
			//�Ը��û����з��в���
			chain.doFilter(request, response);
			
		}else{
			//��������������ת����¼����
			HttpServletResponse resp=(HttpServletResponse)response;
			//��ø�Ŀ¼
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
