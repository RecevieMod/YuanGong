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
		//设置编码集格式
		req.setCharacterEncoding("utf-8");
		//获取查询条件
		int gonghao=Integer.parseInt(req.getParameter("gonghao"));
		//调用查询方法
		Operation operation=new Operation();
		
		ArrayList list=null;
		try{
			list=operation.select(gonghao);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//将查询结果返回前台页面
		req.setAttribute("Selectlist", list);
		//跳转回前台页面
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("/JSP/SelectDemoXianShi.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
