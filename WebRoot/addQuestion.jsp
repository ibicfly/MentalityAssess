<%@taglib prefix="s" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<script type="text/javascript">
/*function addForm()
{
	var questionList=document.getElementById("questionList");
	var form=document.createElement("form");
	form.action="question.do?type=addQuestion";form.method="post";
	form.innerHTML="questionTitle<input type='text' name='qTitle'/>"+
		"index<input type='text' name='index' value='"+sum+"'/>"+
		"<input type='hidden' name='pId'/>"+
		"<input type='submit' value='提交Question'/>";
  	questionList.appendChild(form);
	sum++;
}*/
</script>
  </head>
  <body>
<div id="questionList">
<form action="question.do?type=addQuestion" method="post">
	小问题题目<input type="text" name="qTitle" />
	题号(从0开始)<input type="text" name="qindex" value="${param.qindex}"/>
	<input type="hidden" name="pId" value="${param.pId}"/>
	<input type="submit" value="提交Question"/>
</form>
</div>
</body>
</html>
