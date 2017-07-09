<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
	<form action="answer.do?type=upAnswer" method="post">
	<jstl:forEach var="question" items="${problem.questions }">
	<div>
		${question.qindex}&nbsp&nbsp${question.qTitle}<br/>
		是&nbsp<input type="radio" name="${question.qindex}" value="true"/>
		否&nbsp<input type="radio" name="${question.qindex}" value="false"/><br/>
	</div>
	</jstl:forEach>
	<input type="submit" value="提交"/>
	</form>
  </body>
</html>
