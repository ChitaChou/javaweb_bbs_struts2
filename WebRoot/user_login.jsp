<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Discovery生活社区_用户登录</title>
<script type="text/javascript" src="JS/jquery-1.11.0.js"></script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="CSS/discovery_common.css">
</head>

<body>
	<script type="text/javascript">
		$(function(){
			$("#btn".click(function (){
			if(($(this).prop("#username")) == null || ($(this).prop("#password")) == null){
				alert("用户名或密码为空");
			}}));
		});
	</script>
	<h1 class="loginTitle">Discovery生活社区 用户登录</h1>
	<div class="userLogin">
		<s:form action="checkUser" method="post" theme="simple">
			<div class="login-box">
				<tr>
					<td><s:textfield name="user.user_name" id="username" placeholder="用户名"/></td>
				</tr>
				</br>
				<tr>
					<td><s:password name="user.user_password" id="password" placeholder="密码"/></td>
				</tr>
				</br>
				<tr>
					<td><font color="red"><s:property
								value="fieldErrors['loginError'][0]" /></font></td>
				</tr>
				</br>
				<tr>
					<td><s:submit value="登录" id="loginbtn" /></td>
				</tr>
				</br>
			</div>
		</s:form>
	</div>
</body>
</html>
