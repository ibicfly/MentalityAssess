<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'modifyQuestionjsp' starting page</title>
  </head>
  
  <body>
	修改question
	<form action="question.do?type=editQuestion" method="post">
		小问题题目<input type="text" name="qTitle" value="${question.qTitle }"/>
		题号(从0开始)<input type="text" name="qindex" value="${question.qIndex}"/>
		<input type="hidden" name="pId" value="${question.problem.pId}"/>
		<input type="submit" value="提交Question"/>
	</form>
  </body>
</html>
