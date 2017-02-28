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
			// ת��
			request.setCharacterEncoding("UTF-8");
			//ͨ��HttpServletRequest�ӿڵ�request�����ȡǰ̨����Ĳ���
			Operation opt = new Operation();
			int empno = Integer.parseInt(request.getParameter("userid"));
			String ename = request.getParameter("username");
			String password = request.getParameter("password");
			
			
			//�����ܵĲ�����װ��Employee������
			Employee employee = new Employee();
			employee.setEmpno(empno);
			employee.setEname(ename);
			employee.setPassword(password);
			//�����ܵĲ���¼�뵽���ݿ���
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

