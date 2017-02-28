package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import YuanGongGuanLi.Employee;
import YuanGongGuanLi.Operation;

public class ServletZhuCe extends HttpServlet {

	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// 转码
			request.setCharacterEncoding("UTF-8");
			//通过HttpServletRequest接口的request对象获取前台传输的参数
			Operation opt = new Operation();
			int empno = Integer.parseInt(request.getParameter("userid"));
			String ename = request.getParameter("username");
			String password = request.getParameter("password");
			
			
			//将接受的参数封装到Employee对象中
			Employee employee = new Employee();
			employee.setEmpno(empno);
			employee.setEname(ename);
			employee.setPassword(password);
			//将接受的参数录入到数据库中
			try {
				if(opt.selectZhuCe(empno)==true){
					RequestDispatcher requestdispatcher=request.getRequestDispatcher("/JSP/ZhuCeFailed.jsp?gonghao="+empno);
					requestdispatcher.forward(request, response);
				}else{
						try {
							opt.ZhuCe(employee);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					RequestDispatcher requestdispatcher=request.getRequestDispatcher("/JSP/ZhuCeSuccess.jsp?ename="+ename);
					requestdispatcher.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(req,resp);
								

	}
}

