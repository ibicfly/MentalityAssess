<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
<jsp:include page="head.jsp"></jsp:include>
	测试报告
	问题${problem.pTitle }
	<table>
	<tr>	
		<jstl:forEach var="question" items="${problem.questions}"  >
		<td>${question.qIndex }${question.qTitle }</td>
		</jstl:forEach>
	</tr>
	<tr>	
		<jstl:forEach var="answer" items="${answer.answers }">
		<td>${answer}</td>
		</jstl:forEach>
	</tr>
	</table>
<jsp:include page="tail.jsp"></jsp:include> 
  
  </body>
</html>
