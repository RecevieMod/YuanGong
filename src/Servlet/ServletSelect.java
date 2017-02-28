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
		//ʹ��request���󽫽��ܵĲ�������ת��
		req.setCharacterEncoding("UTF-8");
		//��ȡ��ѯ����
		int empno=Integer.parseInt( req.getParameter("empno"));
		//����Operation�������еĲ�ѯ����
		Operation ot = new Operation();
		ArrayList list = null;
		try {
			list = ot.select(empno);
			System.out.println(list.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ѯ�������ǰ̨ҳ��
		req.setAttribute("emp1List",list);
		//��ת��ǰ̨ҳ��
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("/JSP/Select.jsp?gonghao="+empno);
		requestDispatcher.forward(req, resp);
	}
}