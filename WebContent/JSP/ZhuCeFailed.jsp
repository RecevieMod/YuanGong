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
				<p><font  color="Aqua" face="隶书" size="7">注册失败，<%=request.getParameter("gonghao") %>这个用户ID已经被注册</font></p><br>
				<p></p>
				<h2>请<a href="DengLu.html">登录</a>
					或<a href="ZhuCe.jsp">重新注册</a></h2>				
			</form>
		</center>
	
</body>
</body>
</html>