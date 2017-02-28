<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询信息</title>
<style type="text/css">
	.a{
		margin:5px;
		width:150px;
	}
</style>
</head>
<body>
<form action="/DianXingYingXiao/ServletUpdate" method="post">
	<center>
		<p><font color="red" size="6" face="隶书">请输入要修改的员工编号</font></p>	
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
</body>
</html>