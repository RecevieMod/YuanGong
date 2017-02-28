<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<style type="text/css">
		.image{
		background: url('../imges/html1.jpg') no-repeat;
		}
	</style>
</head>
<body class="image">
		<center>
			<form action="">
				<p><font  color="Aqua" face="隶书" size="7">注册成功！</font></p><br>
				<h2>欢迎你：<%=request.getParameter("ename") %>，请<a href="DengLu.html">登录</a></h2>				
			</form>
		</center>
	
</body>
</html>