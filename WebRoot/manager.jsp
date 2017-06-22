<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  	<h1>管理员界面</h1>
  	<a href="addProblem.jsp">添加问题</a>
  	<a href="manager.do?type=showProblems">修改问题</a>
  	<a href="exit.do">返回主页</a>
  </body>
</html>
