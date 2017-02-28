package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import YuanGongGuanLi.Operation;

public class ServletSelect extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//使用request对象将接受的参数进行转码
		req.setCharacterEncoding("UTF-8");
		//获取查询条件
		int empno=Integer.parseInt( req.getParameter("empno"));
		//调用Operation操作类中的查询方法
		Operation ot = new Operation();
		ArrayList list = null;
		try {
			list = ot.select(empno);
			System.out.println(list.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//将查询结果返回前台页面
		req.setAttribute("emp1List",list);
		//跳转回前台页面
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("/JSP/Select.jsp?gonghao="+empno);
		requestDispatcher.forward(req, resp);
	}
}