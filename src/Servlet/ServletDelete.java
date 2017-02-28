package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import YuanGongGuanLi.Employee;
import YuanGongGuanLi.Operation;

public class ServletDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//使用request对象将接受的参数进行转码
		req.setCharacterEncoding("utf-8");
		//获取查询条件
		int empno=Integer.parseInt(req.getParameter("empno"));
		Employee employee = new Employee();
		employee.setEmpno(empno);
		Operation opt = new Operation();
		try {
			opt.delete(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher requestdispatcher=req.getRequestDispatcher("/JSP/Delete.jsp");
		requestdispatcher.forward(req, resp);
	}

}
