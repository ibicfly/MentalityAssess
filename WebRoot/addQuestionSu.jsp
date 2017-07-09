<%@taglib prefix="s_logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
	注册${qindex}号问题${pTitle }成功
	<s_logic:notEmpty name="qindex">
		<a href="addQuestion.jsp?pId=${pId}&qindex=${qindex+1}">继续添加</a><br/>
	</s_logic:notEmpty>
	<a href="manager.do?type=editProblem&pId=${pId }">回到problem</a>
	
	<a href="manager.jsp">返回管理员界面</a>
<a href="exit.do">退出</a>
  </body>
</html>
