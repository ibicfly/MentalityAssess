<%@taglib prefix="s_bean" uri="http://jakarta.apache.org/struts/tags-tiles" %>
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
  	<jstl:forEach var="question" items="${questions}">
  		<tr><td>${question.qindex }</td>
  		<td>  	
  		<input type="text" value="${question.qTitle}" name=""/></td></tr>
  	</jstl:forEach>
  	</table>
  	<input type="submit" name="修改" 
  		value="确认修改" onclick="return confirm('确认修改')"/>
  </form>
  </body>
</html>
