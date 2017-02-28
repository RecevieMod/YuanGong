<%@page import="YuanGongGuanLi.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<%!
		Employee employee=null;
	%>
	<%
		//调用后台传输的数据
		ArrayList list=(ArrayList)request.getAttribute("emp1List");	
		
		if(list!=null){
			for(int i=0;i<list.size();i++){
				employee=(Employee)list.get(i);	
			}
			String hobby1=employee.getHobby();
	%>	
	<script type="text/javascript">
		function updateData() {
		var hobby=" <%=hobby1%> " ;
		var hobbyOld=hobby.split(",");
		for(i=0;i<=hobbyOld.length;i++){
			for(j=0;j<document.update.hobby.length;j++){
				if(document.update.hobby[j].value==hobbyOld[i]){
					document.update.hobby[j].checked=true;
				}
			}
		}
		}
		function check(){
			var hobby="";
			//获取表单里的数据
			var check=document.update.hobby;
			//将获取得到的数据拼接成一个字符串
			
			for(i=0;i<check.length;i++){
				if(document.update.hobby[i].checked){
					if(i>0){
						hobby=hobby+","+document.update.hobby[i].value;
					}else{
						hobby=document.update.hobby[i].value;
					}
				}
			}
			//将字符串放到hobbyForm的隐藏框中
			document.update.hobbyForm.value=hobby;
		}
	</script>	
 	<style type="text/css">
 		.backgroud{
 			color:red;
 			border:2px;
 			solid #f60;
 		}
 	</style>	
</head>
<body onload="updateData()">
	
	<form action="/DianXingYingXiao/ServletUpdateDemo"  method="post" name="update" >
			<table >
				<tr>
					<td>员工编号：</td>
					<td><input class="backgroud" type="text" readonly="true" value="<%=employee.getEmpno()%>" name="empno"></td>
					<td>员工姓名：</td>
					<td><input type="text" value="<%=employee.getEname() %>" name="ename"></td>
				</tr>
				<tr>
					<td>员工密码：</td>
					<td><input type="password" value="<%=employee.getPassword() %>" name="password"></td>				
					<td>员工性别：</td>
					<td>
						<%
							String sex=employee.getSex();
							if( sex.equals("男")){
						%>
						<input type="radio" value="男" name="sex" checked>男
						<input type="radio" value="女" name="sex">女
						<%
							}else{
						%>
						<input type="radio" value="男" name="sex" >男
						<input type="radio" value="女" name="sex" checked>女
						<%
							}
						%>
					</td>
				</tr>
				<tr>
					<td>工作：</td>
					<td><input type="text" value="<%=employee.getJob()%>" name="job"></td>
					<td>入职日期：</td>
					<td><input type="text" value="<%=employee.getHiredate()%> name="hiredate"></td>
				</tr>
				<tr>	
					<td>工资：</td>
					<td><input type="text" value="<%=employee.getSal() %>" name="sal"></td>
					<td>部门编号：</td>
					<td><input type="text" value="<%=employee.getDeptno() %>" name="deptno"></td>
				</tr>
				<tr>
					<td>爱好：</td>
					<td>
						<input name="hobby" type="checkbox"   value="看片"  checked>看片
						<input name="hobby" type="checkbox"   value="篮球" >篮球
						<input name="hobby" type="checkbox"   value="健身" >健身<br>
						<input name="hobby" type="checkbox"   value="游泳" >游泳
						<input name="hobby" type="checkbox"   value="滑雪" >滑雪
						<input name="hobby" type="checkbox"   value="打LOL" >打LOL<br>
						<input name="hobby" type="checkbox"   value="学习" >学习
						<input name="hobbyForm" type="hidden" value="" id="hobbyForm">
				</td>
				</tr>
				<tr>
					<td><input type="submit" value="修改" onclick="check() "></td><br>
					<td><input type="reset" value="重置"></td><br>
				</tr>
			</table>
			<%
				}else{
					System.out.println(" 程序出错了 ");
				}
			%>	
		</form>	
</body>
</html>