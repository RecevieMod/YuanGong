<%@page import="org.apache.catalina.connector.Request"%>
<%@page import="java.util.ArrayList"%>
<%@page import="YuanGongGuanLi.Employee"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%//调用后台传输的数据
	ArrayList list=(ArrayList)request.getAttribute("Selectlist");
	Employee employee=null;
	%>
	<center>
	<p><font color="red" size="5" face="隶书">员工编号为<%=request.getParameter("gonghao")%>的详细信息为：</font></p>
	<table border="2">
	<th>员工编号</th>
	<th>员工姓名</th>
	<th>密码</th>
	<th>性别</th>
	<th>工作</th>
	<th>入职日期</th>
	<th>员工工资</th>
	<th>上级领导编号</th>
	<th>爱好</th>
	
	<%
	if(list!=null){
		for(int i=0;i<list.size();i++){
			employee=(Employee)list.get(i);
	%>
	<tr>
		<td><%=employee.getEmpno() %></td>
		<td><%=employee.getEname() %></td>
		<td><%=employee.getPassword() %></td>
		<td><%=employee.getSex() %></td>
		<td><%=employee.getJob() %></td>
		<td><%=employee.getHiredate() %></td>
		<td><%=employee.getSal() %></td>
		<td><%=employee.getDeptno() %></td>
		<td><%=employee.getHobby() %></td>
		
	</tr>
	<%
		}
	}
	%>
	</table>
	<table>
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td><a href="/DianXingYingXiao/JSP/Select.jsp">返回</a></td>
	</tr>
	</table>
	</center>
</body>
</html>