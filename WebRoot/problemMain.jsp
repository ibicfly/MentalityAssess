<%@taglib prefix="s_html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@taglib prefix="s_logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  这个页面展示了所有的问题，采用分页技术
  <table>
	<tr><td>题目</td></tr>
	<jstl:forEach var="problem" items="${problemList}" >
		<tr><td>${problem.pTitle}</td>
	</jstl:forEach>
	</table>
	<s_logic:greaterThan value="1" name="pagenow">
	<a href="problem.do?pagenow=${pagenow-1}">上一页</a>
	</s_logic:greaterThan>
	<jstl:forEach var="pagenum" begin="1" end="${pagecount}" >
		<a href="problem.do?pagenow=${pagenum}">${pagenum}</a>
	</jstl:forEach>
	<s_logic:lessThan value="${pagecount}" name="pagenow">
		<a href="problem.do?pagenow=${pagenow+1}">下一页</a>
	</s_logic:lessThan>
	<a href="${window.location.host}${ pageContext.request.contextPath }">返回主页</a>
  </body>
</html>