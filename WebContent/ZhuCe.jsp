<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<style type="text/css">
		.imge{
			background: url('imges/html1.jpg') no-repeat;
		}
		.BianJu{
			margin-top: 180px;
			
			width: 400px;
			height: 240px;
			background: url('imges/html3.jpg') no-repeat; 
			-webkit-box-shadow: 10px 10px 10px #FFFFFF;
			box-shadow: 10px 10px 10px #FFFFFF;
			filter:progid:DXImageTransform.Microsoft.Shadow(color=#909090,direction=120,strength=3);
		}
		.KuangBianJU{
			width:150px;
			margin: 6px;
		}
	</style>
	<script type="text/javascript">
		function Check(){
			if(UserIdCheck() & UserNameCheck() & check_Password() & check_AgianPassword()){
				return true;
				alert("+++++++++++");
			}else{
				return false;
				alert("++++");
			}
			
		}
//===============检查输入用户ID是否正确=========================================
		function UserIdCheck(){
		var CheckIdflage=false;
		var checkId=/^\w{4}$/;
		var userid1=document.getElementById("userid").value;
			if(!checkId.test(userid1)){
				document.getElementById("Id_Check_Error").style.color="red";
				document.getElementById("Id_Check_Error").innerHTML=" 用户ID错误，应该为4位的数字";
				CheckIdflage=false;
			}else{
				document.getElementById("Id_Check_Error").style.color="black";
				document.getElementById("Id_Check_Error").innerHTML=" √ 用户ID可用 ";
				CheckIdflage=true;
			}
			return CheckIdflage;
		}
//===================检查输入用户姓名是否正确========================================================
		function UserNameCheck(){
		var CheckNameflage=false;
		var checkName=/^[A-Za-z]{3,6}$/;
		var checkName1=/^[\u4e00-\u9fa5]{2,4}$/;
		var username=document.getElementById("username").value;
			if(checkName.test(username)){
				
				document.getElementById("Name_Check_Error").style.color="black";
				document.getElementById("Name_Check_Error").innerHTML=" √ 用户名可用  ";
				CheckNameflage=true;
			}else if(checkName1.test(username)){
				document.getElementById("Name_Check_Error").style.color="black";
				document.getElementById("Name_Check_Error").innerHTML=" √ 用户名可用  ";
				CheckNameflage=true;
			}else{
				document.getElementById("Name_Check_Error").style.color="red";
				document.getElementById("Name_Check_Error").innerHTML="请输入3~6位字母或者2~4位汉字 ";
				CheckNameflage=false;
				
			}
			 return CheckNameflage;
		}
//===================检查输入用户密码是否符合格式============================================================
		function check_Password(){
		 	var checkPasswordflage=false;
		 	var password1 = document.getElementById("password").value;
		    if (password1.length >= 6 && password1.length <= 15) {
		    	checkPasswordflage = true;
		       	document.getElementById("Password_Check_Error").style.color='#007ACC';
		        document.getElementById("Password_Check_Error").innerHTML = "  √ 密码可用 ";
		    } else {
		    	checkPasswordflage = false;
		       	document.getElementById("Password_Check_Error").style.color='red';
		       	document.getElementById("Password_Check_Error").innerHTML = " 密码至少为 6 个字符 ";
		    }
			return checkPasswordflage;
		 }
//====================确认输入密码=====================================================
		 function check_AgianPassword()
		 {
		 	var checkPasswordAgianflag=false;
			var password1 = document.getElementById("password").value;
		    var password2 = document.getElementById("passwordAgian").value;
		 		if(password2==""){
		 			checkPasswordAgianflag = false;
		        	document.getElementById("Password_Check_Error1").style.color='red';
			        document.getElementById("Password_Check_Error1").innerHTML = "  输入的密码不能为空 ";	
		 		}else if (password1 == password2){
			       document.getElementById("Password_Check_Error1").style.color='#007ACC';
			        document.getElementById("Password_Check_Error1").innerHTML = "√ 密码设置完成";
			        checkPasswordAgianflag = true;
			    } else {
			        checkPasswordAgianflag = false;
		        	document.getElementById("Password_Check_Error1").style.color='red';
			        document.getElementById("Password_Check_Error1").innerHTML = " 两次密码输入不同 ";
			        
			    }

			    return checkPasswordAgianflag;
		 }
	</script>
</head>
<body class="imge">
		<center>
			<form action="/DianXingYingXiao/ServletZhuCe" method="post" onsubmit="return Check()">
				<div >
					<p><font class="b" color="Aqua" face="隶书" size="7">员工注册</font></p><br>
					&nbsp;&nbsp;用户ID：<input type="text" id="userid" name="userid" onblur="UserIdCheck()" maxlength="8" class="KuangBianJU" value=""><br>
										<label id="Id_Check_Error"></label><br>
					用户姓名：<input type="text" id="username" name="username" class="KuangBianJU" value="" onblur="UserNameCheck()"><br>
							<label id="Name_Check_Error"></label><br>
					用户密码：<input type="password" id="password" class="KuangBianJU" name="password" maxlength="8" value="" onblur="check_Password()"><br>
							<label id="Password_Check_Error"></label><br>
					确认密码：<input type="password" id="passwordAgian" class="KuangBianJU" name="password" maxlength="8" value="" onblur="check_AgianPassword()"><br>
							<label id="Password_Check_Error1"></label><br>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="" value="注册" class="a" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" name="" value="重置" ></p>
				</div>
			</form>
		</center>
</body>
</html>