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
	var username=document.getElementById("username").value;
	var patrn=/^[a-z,A-z][a-z,A-z,0-9]{5,31}/;
	var warn=document.getElementById("warnu");
	if (!patrn.exec(username)) 
	{warn.style.visibility='visible';passpession=false;}
	else{ warn.style.visibility='hidden';passpession=true;}
}
function checkPassword()
{
	var password=document.getElementById("password").value;
	var patrn=/\w{6,31}/;
	var warn=document.getElementById("warnp");
	if (!patrn.exec(password)) 
	{warn.style.visibility='visible';repasspession=false;}
	else{warn.style.visibility='hidden';repasspession=true;}
}
function rePassword()
{
	var pass=document.getElementById("password").value;
	var repass=document.getElementById("repassword").value;
	var warn=document.getElementById("warnrp");
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
	var submit=document.getElementById("submit");
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
<form action="register.do" method="post" onmousemove="confirm()" id="register">
  用户名<input type="text" name="username" id="username" onblur="checkUsername()" value="${username}"/>
<font color="red" style="visibility: hidden;" id="warnu">用户名不合法</font>
<font color="red" >${exist}</font><br/>
  密　码<input type="password" name="password" id="password" onblur="checkPassword()" />
<font color="red" style="visibility: hidden;" id="warnp">密码不合法</font><br/> 
  确认密码<input type="password" name="repassword" id="repassword" onblur="rePassword()" /> 
<font color="red" style="visibility: hidden;" id="warnrp">两次密码不一致</font><br/>
<input type="submit" value="注册" disabled="disabled" id="submit"/>
<jsp:include page="tail.jsp"></jsp:include>
</form>
</body>
</html>