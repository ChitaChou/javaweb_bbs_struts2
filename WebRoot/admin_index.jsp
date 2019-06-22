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
    
    <title>Discovery生活论坛_管理员控制面板</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>请选择以下管理选项</h1>
        当前管理员:<s:property value="#session.currentAdmin"/> <a href="adminLogout">退出</a><br>
    <a href="allUsersIndex">管理所有用户</a>
    <a href="allThreadsIndex">管理所有帖子</a>
    <a href="allReplyIndex">查看所有回复</a>
    <a href="edit!toEditAdminPage?editAdminName=<s:property value="#session.currentAdmin"/>">管理员信息编辑</a><br>
    <font color="red"><s:property value="fieldErrors['editNotice'][0]" /></font>     
  </body>
</html>
