<%@page import="YuanGongGuanLi.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<style type="text/css">
		.a{
			margin:5px;
			width:150px;
		}
	</style>
</head>
<body>
	<form action="/DianXingYingXiao/ServletSelect" method="post">
		<center>
		<p><font color="red" size="6" face="隶书">请输入要查询的员工编号</font></p>	
			<table>
				<tr>
					<p><td>员工编号：</td>
					<td><input name="empno" type="text" value="" class="a"></td></p>
				</tr>
				<tr>
					<td><input type="submit" value="提交"></td>
					<td><input type="reset" value="重置"></td>
				</tr>
			</table>
	</center>
	</form>
	<hr size="3" color="red" width="100%">
	<%
	ArrayList list=(ArrayList)request.getAttribute("emp1List");
	Employee employee=null;
	
	%>
	<center>
	<p><font color="red" size="5" face="隶书">员工编号为<%=request.getParameter("gonghao")%>的信息为：</font></p>
	<table border="2">
	<th>员工编号</th>
	<th>员工姓名</th>
	<th>性别</th>
	<th>工作</th>
	<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
	<%
	if(list!=null){
		for(int i=0;i<list.size();i++){
			employee=(Employee)list.get(i);
	%>
	<tr align="center">
		<td ><%=employee.getEmpno() %></td>
		<td><%=employee.getEname() %></td>
		
		<td><%=employee.getSex() %></td>
		
		<td><%=employee.getJob() %></td>
		<td>
			<a href="ServletSelectDemo?gonghao=<%=employee.getEmpno() %>">查看详细信息</a>
		</td>
	</tr>
	<%		
		}
	}
	%>
	</table>
	</center>
</body>
</html>