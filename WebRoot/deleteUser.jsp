<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript">
  //可以采用计时器技术，通知管理员删除成功
  </script>
  </head>
  <body>
<h1>删除用户成功</h1>
<jsp:forward page="administrator.do?type=modify"></jsp:forward>
<a href="administrator.jsp">返回管理界面</a>
<a href="${window.location.host}${ pageContext.request.contextPath }">回到首页</a>
  </body>
</html>
