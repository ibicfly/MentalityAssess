<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<script type="text/javascript">
var userpession=false;
var passpession=false;
var repasspession=false;
function checkUsername()
{
	var username=document.getElementById("r_username").value;
	var patrn=/^[a-z,A-z][a-z,A-z,0-9]{5,31}/;
	var warn=document.getElementById("r_warnu");
	window.alert(patrn.exec(username));
	window.alert(username);
	if (!patrn.exec(username)) 
	{warn.style.visibility='visible';passpession=false;}
	else{ warn.style.visibility='hidden';passpession=true;}
}
function checkPassword()
{
	var password=document.getElementById("r_password").value;
	var patrn=/\w{6,31}/;
	var warn=document.getElementById("r_warnp");
	if (!patrn.exec(password)) 
	{warn.style.visibility='visible';repasspession=false;}
	else{warn.style.visibility='hidden';repasspession=true;}
}
function rePassword()
{
	var pass=document.getElementById("r_password").value;
	var repass=document.getElementById("r_repassword").value;
	var warn=document.getElementById("r_warnrp");
	if(pass!=repass)
	{
		warn.style.visibility='visible';
		userpession=false;
	}else
	{
		warn.style.visibility='hidden';
		userpession=true;
	}
}
function confirm()
{
	var submit=document.getElementById("r_submit");
	if(userpession&&passpession&&repasspession)
	{ 
		submit.disabled=false;	}
	else{
		submit.disabled=true;
	}
}
</script>
  </head>
  <body >
  <jsp:include page="head.jsp"></jsp:include>
<form action="register.do" method="post" onmousemove="confirm()" id="r_register">
  用户名<input type="text" name="username" id="r_username" onblur="checkUsername()" value="${username}"/>
<font color="red" style="visibility: hidden;" id="r_warnu">用户名不合法</font>
<font color="red" >${exist}</font><br/>
  密　码<input type="password" name="password" id="r_password" onblur="checkPassword()" />
<font color="red" style="visibility: hidden;" id="r_warnp">密码不合法</font><br/> 
  确认密码<input type="password" name="repassword" id="r_repassword" onblur="rePassword()" /> 
<font color="red" style="visibility: hidden;" id="r_warnrp">两次密码不一致</font><br/>
<input type="submit" value="注册" disabled="disabled" id="r_submit"/>
<jsp:include page="tail.jsp"></jsp:include>
</form>
</body>
</html>