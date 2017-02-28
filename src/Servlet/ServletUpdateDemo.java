package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import YuanGongGuanLi.Employee;
import YuanGongGuanLi.Operation;

public class ServletUpdateDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//通过HttpServletRequest接口的request对象获取前台传输的参数
		if(req.getParameter("empno")!=null){
				int empno = Integer.parseInt(req.getParameter("empno"));
				String ename = req.getParameter("ename");
				String password = req.getParameter("password");
				String sex = req.getParameter("sex");
				String job = req.getParameter("job");
				String hiredate = req.getParameter("hiredate");
				int sal =Integer.parseInt( req.getParameter("sal"));
				int deptno = Integer.parseInt(req.getParameter("deptno"));
				String hobby = req.getParameter("hobbyForm");
				
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
					opt.update(employee);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}else{
			System.out.println("出错了");
		}
				RequestDispatcher requestdispatcher=req.getRequestDispatcher("/JSP/Update.jsp");
				requestdispatcher.forward(req, resp);
	}
}
