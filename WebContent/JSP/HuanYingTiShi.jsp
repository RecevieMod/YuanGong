<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	.image{
		background: url('../imges/background1.jpg') repeat;
		margin-top:10%;	
	}
</style>
</head>
<body class="image" >
	<center>
	<p>
		<font color="red"  face="隶书" size="5" >>></font>
		<font color="Black" face="隶书" size="5"  > 请选择要对员工表进行的操作 </font>
		<font color="red" face="隶书" size="5" ><<</font>
	</p>
	<p><a href="../html/Add.html" target="rightXianShi">添加数据</a></p>
	<p><a href="/DianXingYingXiao/JSP/Delete.jsp" target="rightXianShi">删除数据</a></p>
	<p><a href="/DianXingYingXiao/JSP/Update.jsp" target="rightXianShi">修改数据</a></p>
	<p><a href="/DianXingYingXiao/JSP/Select.jsp" target="rightXianShi">查询数据</a></p>
	</center>
</body>
</html>