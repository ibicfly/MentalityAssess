<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  <script type="text/javascript">
  function check(obj){
  var Id1=obj.id;
  var Identify=Id1.substring(Id1.length-1,Id1.length);
	if(Identify == 1 && obj.checked == true){
		var Id2=Id1.substring(0,Id1.length-1)+'2';
		document.getElementById(Id2).checked = false;
	 }
	else if(Identify == 2 && obj.checked == true){
		var Id2=Id1.substring(0,Id1.length-1)+'1';
		document.getElementById(Id2).checked = false;
	}
	}
  </script>
  	<form action="answer.do?type=upAnswer" method="post">
	<jstl:forEach var="question" items="${problem.questions }">
	<div>
		${question.qIndex}&nbsp&nbsp${question.qTitle}<br/>
		是&nbsp<input type="checkbox" name="answers" value="true" 
		id="checkbox${question.qIndex }1" onclick ="check(this)"  /><br/>
		否&nbsp<input type="checkbox" name="answers" value="false"
		id="checkbox${question.qIndex }2" onclick ="check(this)"/><br/>
	</div>
	</jstl:forEach>
	<input type="hidden" name="uId" value="${sessionScope.username}" />
	<input type="hidden" name="pId" value="${problem.pId }" />
	<input type="submit" value="提交"/>
	</form>

  </body>
</html>
