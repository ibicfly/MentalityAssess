 <%@taglib prefix="s" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
  .home
  {
  	border: solid;
  	border-color: red;
  }
  .navi{
  border: solid;
  border-color: blue;
  }
  .login
  {
  	margin: 0px;
  	display: inline;
  }
  </style>
  <script type="text/javascript" >
  function validateUser()
  {
  	var username="${sessionScope.username}";
  	if(username!=null&&username!="")
  	{
  		document.getElementById("head_welcome").style.visibility='visible';
  		document.getElementById("head_register").style.visibility='hidden';
 		document.getElementById("head_login").style.visibility='hidden';
 	}else
 	{
 		document.getElementById("head_welcome").style.visibility='hidden';
 		document.getElementById("head_register").style.visibility='visible';
  		document.getElementById("head_login").style.visibility='visible';
  	}
  }
  </script>
  </head>
  <body onload="validateUser()">
<!-- logo -->
<div class="home">
	<span><a href="${window.location.host}${ pageContext.request.contextPath }">
			<img src="Image/logo.png"></img></a></span>
	<form action="login.do" class="login" method="post"
		 style="visibility: visible;" id="head_login" >
	<input type="text" name="username" value="${cookie['username'].value}" id="head_username"/>
	<input type="checkbox" name="remberUser" id="head_remberUser" />
	<input type="password" name="password" id="head_password" />
	<input type="submit" value="登陆" id="head_submit" >
	</form>
	<a href="Register.jsp" id="head_register">注册</a>
	<a href="exit.do">退出登陆</a>
	<span style="visibility: hidden" id="head_welcome">欢迎用户<a href="#">${sessionScope.username}</a></span>
</div>
<!-- navi -->
<div class="navi"><a href="problem.do?type=showByPage">心理小测试</a>
<!-- 	 <a href="#">心理知识</a>
	 <a href="#">心理探讨</a>
	  -->  
</div>
  </body>
</html>
