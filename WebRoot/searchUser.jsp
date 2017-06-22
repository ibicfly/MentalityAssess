<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s_logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
<h1>结果</h1>
	<s_logic:empty name="noUser">
		<table>
		<tr><td>uid</td><td>${searchRes.uId }</td></tr>
		<tr><td>username</td><td>${searchRes.username }</td></tr>
		<tr><td>password</td><td>${searchRes.password }</td></tr>
		</table>		
	</s_logic:empty>
	<s_logic:notEmpty name="noUser">
		<h1>${noUser }</h1>
	</s_logic:notEmpty>
<a href="administrator.jsp">返回管理界面</a>
<a href="${window.location.host}${ pageContext.request.contextPath }">回到首页</a>
  </body>
</html>
