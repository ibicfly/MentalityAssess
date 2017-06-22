<%@taglib prefix="s_logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
	<h1>${managerSu }</h1><br/>
	<s_logic:match value="添加成功" name="managerSu">
		<a href="addQuestion.jsp?pId=${pId }&qindex=0">给${pTitle }添加问题</a><br/>
	</s_logic:match>
	<a href="manager.jsp">返回管理员界面</a>
<s_logic:notEmpty name="pagenow" >
<a href="manager.do?type=showProblems&pagenow=${pagenow }">返回修改问题</a>
</s_logic:notEmpty>
<a href="exit.do">退出</a>
  </body>
</html>
