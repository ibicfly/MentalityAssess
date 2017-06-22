<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript">
  	function validate()
  	{
  		var title=document.getElementById("pTitle").value;
  		var pattern=/[\w,\S,\s]{6,}/;
  		if(title!=null&&pattern.test(title))
  		{
  			return true;
  		}else
  		{
  			window.alert("请正确输入题目");
  			return false;
  		}
  	}
  </script>
  </head>
  <body>
	<form method="post" action="manager.do?type=addProblem">
		<div>Problem标题<input type="text" name="pTitle" id="pTitle" value="${pTitle}">
		<b style="color: red;">${p_exist}</b>
		</div>
		<input type="submit" value="添加problem" onclick="return validate()"/>
	</form>
	<a href="manager.jsp">返回管理界面</a>	
  </body>
</html>