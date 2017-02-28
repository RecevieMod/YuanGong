<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		欢迎<%=request.getParameter("userid") %>登录系统
	</h3>
	<%
		response.setHeader("refresh", "3;url=JSP/HuanYing.jsp");
	%>
	<h3>
		3秒之后将会跳转到主界面，如果没有跳转成功，请点击<a href="JSP/HuanYing.jsp" >跳转</a>
	</h3>
	
</body>