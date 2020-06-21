<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function flush(){
		var dom =document.getElementById("imgid");
		var data=new Date();
		dom.src="/LOGIN/immg?"+data.getTime();
		}
	</script>
	
  </head>
  
  <body>
   			<form action='login' method="post">
   			用户名：<input type="text" name="name" /><br/>
   			密 码 ：<input type="text" name="pwd" /><br/>
   			验证码：<input type="text" name="checkCode"><img src="/LOGIN/immg" id='imgid'><a href="javascript:flush()">看不清</a>
   			<br/>
   			<input type="submit"value="登录" />&nbsp;
   			<input type="reset"value="重置" />
   			<a href='jsps/Reg.jsp'>注册</a>
   			
   		</form>
  </body>
</html>
