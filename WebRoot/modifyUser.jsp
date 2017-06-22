<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s_logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@taglib prefix="s_bean" uri="http://jakarta.apache.org/struts/tags-bean" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <form action="administrator.do?type=delete" method="post">
	<table>
		<tr><td>用户id</td><td>用户名</td><td>密码</td></tr>
  	<jstl:forEach var="user" items="${userlist}" >
		<tr><td>${user.uId}</td><td>${user.username}</td>
		<td>${user.password}</td>
		<td><input type="hidden" name="username" value="${user.username }"/>
			<input type="hidden" name="pagenow" value="${pagenow }"/>
			<input type="submit" name="删除" 
			onclick="return confirm('${user.username}')" value="删除"/></td>
	</jstl:forEach>
	</table>
	<s_logic:greaterThan value="1" name="pagenow">
	<a href="administrator.do?type=modify&pagenow=${pagenow-1}">上一页</a>
	</s_logic:greaterThan>
	<jstl:forEach var="pagenum" begin="1" end="${pagecount}" >
		<a href="administrator.do?type=modify&pagenow=${pagenum}">${pagenum}</a>
	</jstl:forEach>
	<s_logic:lessThan value="${pagecount}" name="pagenow">
		<a href="administrator.do?type=modify&pagenow=${pagenow+1}">下一页</a>
	</s_logic:lessThan>
	</form>
<a href="administrator.jsp">返回管理界面</a>
<a href="${window.location.host}${ pageContext.request.contextPath}">回到首页</a>
  </body>
</html>