<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
  <jsp:include page="head.jsp"></jsp:include>
	成功登陆 欢迎用户${username }
	<a href="home.jsp">返回首页</a>
	<jsp:include page="tail.jsp"></jsp:include>
  </body>
</html>
