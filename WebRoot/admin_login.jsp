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
    
    <title>Discovery生活社区_管理员登录入口</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/GeneralCSS.css">
  </head>
  
  <body>
  <s:i18n name="globalMessages">
  	<a href="adminLogin.action?request_locale=zh_CN"><s:text name="简体中文"></s:text></a>
  	<a href="adminLogin.action?request_locale=en_US"><s:text name="English"></s:text></a>
  	<a href="adminLogin.action?request_locale=ja_JP"><s:text name="日本語"></s:text></a>
  	<s:form action="checkAdmin" method="post" theme="simple">
  		<h1>Discovery生活社区——管理员登录入口</h1>
  		<tr>
  			<td><s:text name="username" /></td>
  			<td><s:textfield name="admin.admin_name" /></td>
  		</tr></br>
  		<tr>
  			<td><s:text name="password" /></td>
  			<td><s:password name="admin.admin_password" /></td>
  			<td><font color="red"><s:property value="fieldErrors['loginError'][0]" /></font></td>
  		</tr></br>
  		<tr>
  			<td><s:submit value="Login" /></td>
  		</tr></br>
  	</s:form>
  </s:i18n>
  </body>
</html>
