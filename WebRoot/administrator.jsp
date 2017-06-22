<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript">
  	function cleanText()
  	{
  		var text=document.getElementById("username");
  		text.value="";
  	}
  </script>
  </head>
  <body>
  	<h1>最高管理员界面</h1>
  	<a href="administrator.do?type=modify">修改用户</a>
  	<form action="administrator.do?type=search" method="post">
 		 <input type="text" name="username" id="username" value="请输入用户名" onfocus="cleanText()"/>
 		 <input type="submit" value="搜索"/>
	<a href="exit.do">退出登陆</a>
  	</form>
  </body>
</html>
