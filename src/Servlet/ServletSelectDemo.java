package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import YuanGongGuanLi.Operation;

public class ServletSelectDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���ñ��뼯��ʽ
		req.setCharacterEncoding("utf-8");
		//��ȡ��ѯ����
		int gonghao=Integer.parseInt(req.getParameter("gonghao"));
		//���ò�ѯ����
		Operation operation=new Operation();
		
		ArrayList list=null;
		try{
			list=operation.select(gonghao);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//����ѯ�������ǰ̨ҳ��
		req.setAttribute("Selectlist", list);
		//��ת��ǰ̨ҳ��
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("/JSP/SelectDemoXianShi.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
