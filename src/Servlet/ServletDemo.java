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
		// 转码
		request.setCharacterEncoding("UTF-8");
		//通过HttpServletRequest接口的request对象获取前台传输的参数
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String job = request.getParameter("job");
		String hiredate = request.getParameter("hiredate");
		int sal =Integer.parseInt( request.getParameter("sal"));
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String hobby = request.getParameter("hobbyForm");
		
		//将接受的参数封装到Employee对象中
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
		
		//将接受的参数录入到数据库中
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


