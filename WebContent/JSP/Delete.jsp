<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>删除数据</title>
<style type="text/css">
	.a{
		margin:5px;
		width:200px;
	}
</style>
	<script type="text/javascript">
		function show(){
			var value=document.Delete.empno.value;
			if(confirm("你将要删除员工号为"+value+"的所有数据  ！")){
				return true;
			}else{
				return false;
			}
			
		}
	</script>
</head>
<body>
	<form action="/DianXingYingXiao/ServletDelete" method="post" name="Delete" onsubmit="return show()">
		<center>
			<p><font color="red" size="6" face="隶书">请输入要删除的员工编号</font></p>	
				<table>
					<tr>
						<p><td>员工编号：</td>
						<td><input name="empno" type="text" value="" class="a"></td></p>
					</tr>
					<tr>
						<td><input type="submit" value="提交" ></td>
						<td><input type="reset" value="返回" ></td>
					</tr>
				</table>
		</center>
	</form>
</body>
</html>