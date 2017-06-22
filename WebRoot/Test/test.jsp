<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
<div id="container">
</div>
<script>
 window.onload = function () {
  var str='';
  for(var i=0; i<30 ;i++){
   var r = parseInt(Math.random()*100); //随机生成一个数字
   str += "<a href='http://www.baidu.com'>"+i+"</a></br>"; //拼接str
  }
  document.getElementById('container').innerHTML=str;
 }
</script>  </body>
</html>
