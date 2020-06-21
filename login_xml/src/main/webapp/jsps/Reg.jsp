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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function check(){
			var aa =document.getElementById("name");
			var bb=document.getElementById("spanid");
			//alert(aa.value);
			if(aa.value==""||aa.value==" "){
			bb.innerHTML="请输入合法的用户名。。".fontcolor("red");
			}else{
			bb.innerHTML="";
			}
		}
	
		function check1(){
			var aa =document.getElementById("pwd");
			var bb=document.getElementById("spanid1");
			//alert(aa.value);
			if(aa.value==""||aa.value==" "){
			bb.innerHTML="密码格式不正确。。".fontcolor("red");
			}else{
			bb.innerHTML="";
			}
		}
		
		function check2(){
			var aa=document.getElementById("pwd");
			var bb=document.getElementById("pwd2");
			var cc=document.getElementById("spanid2");
			if(aa.value==bb.value){//比较值是都相等，aa,bb都是节点
				cc.innerHTML="";			
				}else{
				cc.innerHTML="两次密码输入不正确".fontcolor("red");
				}
			
		}
	</script>
  </head> 
  
  <body>
   		<form action='reg' method="post">
   			用户 名：<input type="text" name="name" onblur="check()" id="name"/><span id="spanid"></span><br/>
   			密    码  ： <input type="text" name="pwd" id="pwd" onblur="check1()"/><span id="spanid1"></span><br/>
   			确认密码 ：<input type="text" name="pwd2" id="pwd2" onblur="check2()"/><span id="spanid2"></span><br/>
   			<input type="submit"value="注册" />&nbsp;
   			<input type="reset"value="重置" />
   			
   		</form>
  </body>
</html>
