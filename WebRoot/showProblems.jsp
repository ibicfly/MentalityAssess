<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s_logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
  .edit{
  	text-decoration: none;
  }
  </style>
<script type="text/javascript">
	function change(pid)
	{
		var form=document.getElementById("form"+pid);
		form.action="manager.do?type=editProblem";
	}
</script>
  </head>
  <body>
<table>
	<tr><td>ProblemId</td><td>题目</td><td>完成用户人数</td></tr>
	<jstl:forEach var="problem" items="${problemList}" >
		<tr><td>${problem.pId}</td><td>${problem.pTitle}</td>
		<td>
		  <form action="manager.do?type=delete" method="post" id="form${problem.pId}">
			<input type="hidden" name="pId" value="${problem.pId}"/>
			<input type="hidden" name="pagenow" value="${pagenow}"/>
			<input type="hidden" name="pTitle" value="${problem.pTitle }"/>
			<input type="submit"
			onclick="return confirm('删除')" value="删除"/>
			<input type="submit" value="修改" onclick="return change(${problem.pId})"/>
			</form>
			</td>
	</jstl:forEach>
	</table>
	<s_logic:greaterThan value="1" name="pagenow">
	<a href="manager.do?type=showProblems&pagenow=${pagenow-1}">上一页</a>
	</s_logic:greaterThan>
	<jstl:forEach var="pagenum" begin="1" end="${pagecount}" >
		<a href="manager.do?type=showProblems&pagenow=${pagenum}">${pagenum}</a>
	</jstl:forEach>
	<s_logic:lessThan value="${pagecount}" name="pagenow">
		<a href="manager.do?type=showProblems&pagenow=${pagenow+1}">下一页</a>
	</s_logic:lessThan>
<a href="manager.jsp">返回管理界面</a>
<a href="exit.do">退出</a>
</body>
</html>
