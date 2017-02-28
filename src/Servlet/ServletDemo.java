package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import YuanGongGuanLi.Employee;
import YuanGongGuanLi.Operation;

public class ServletDemo extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ת��
		request.setCharacterEncoding("UTF-8");
		//ͨ��HttpServletRequest�ӿڵ�request�����ȡǰ̨����Ĳ���
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String job = request.getParameter("job");
		String hiredate = request.getParameter("hiredate");
		int sal =Integer.parseInt( request.getParameter("sal"));
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String hobby = request.getParameter("hobbyForm");
		
		//�����ܵĲ�����װ��Employee������
		Employee employee = new Employee();
		employee.setEmpno(empno);
		employee.setEname(ename);
		employee.setPassword(password);
		employee.setSex(sex);
		employee.setJob(job);
		employee.setHiredate(hiredate);
		employee.setSal(sal);
		employee.setDeptno(deptno);
		employee.setHobby(hobby);
		
		//�����ܵĲ���¼�뵽���ݿ���
		Operation opt = new Operation();
		try {
			opt.add(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher requestdispatcher=request.getRequestDispatcher("/html/Add.html");
		requestdispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
		
	}
	
}


