<%@page import="java.util.ArrayList"%>
<%@page import="YuanGongGuanLi.Operation"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		boolean check=false;
	%>
	<%
		//获取登录信息
		String userid=(String)request.getParameter("userid");
		String password=(String)request.getParameter("password");
		//根据获取的数据，和后台数据进行匹配，若匹配成功则跳转到欢迎界面，若不成功则返回到登录界面
		if(userid!="" && userid!=null && password!="" && password!=null){
			int userid1=Integer.parseInt(userid);
			Operation opt = new Operation();
			ArrayList list=opt.DengLuCheck(userid1,password);
			if(list.size()>0){
				check = true;
			}
		}
	%>
	<% 
		if(check){//标志位是true表明登陆成功，跳转到成功页面
			session.setAttribute("userid", userid);
		
		
	%>
	<jsp:forward page="/JSP/DengLuSuccee.jsp">
		<jsp:param name="userid" value="<%=userid%>"/>
	</jsp:forward>
	<% 		
		}else{//登陆失败，跳转到失败页面
	%>
	<jsp:forward page="/JSP/loginFailed.jsp"/>
	<% 
		}
	%>
</body>
</html>