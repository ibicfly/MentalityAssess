<%@taglib prefix="s_bean" uri="http://jakarta.apache.org/struts/tags-tiles" %>
<%@taglib prefix="s" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <form action="manager.do?type=saveEdit" method="post">
  	pId<h1>${pId }</h1>
  	pTitle<input type="text" name="pTitle" value="${pTitle}"/>
  	<input type="hidden" name="pagenow" value="${pagenow }"/>
  	<table style="border-style: solid;border-color: red;">
	<a href="addQuestion.jsp?pId=${pId }&qindex=0">添加question</a><br/>
  	<jstl:forEach var="question" items="${questions}">
  		<tr><td>${question.qIndex }</td>
  		<td>
  		<input type="text" value="${question.qTitle}" name=""/></td>
  		<td><a href="question.do?type=delQuestion&qId=${question.qId}&pId=${question.problem.pId}" onclick="return confirm('是否确认删除')">删除question</a></td>
  		<td><a href="question.do?type=showQuestion&qId=${question.qId}">修改question</a></td></tr>
  	</jstl:forEach>
  	</table>
  	<a href="manager.do?type=showProblems&pagenow=${pagenow }">返回修改问题</a>
  	
  	<input type="submit" name="修改" 
  		value="确认修改" onclick="return confirm('确认修改')"/>
  </form>
  </body>
</html>
