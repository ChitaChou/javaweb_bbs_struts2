<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Discovery生活社区_全部用户_管理员控制面板</title>
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
    <h1>全部用户列表</h1>
    <table width="1000" height="256" border="1" cellpadding="1"
		cellspacing="1" align="center">
		<caption>List遍历-用户</caption>
		<tr>
		<td>ID</td><td>用户名</td><td>昵称</td><td>性别</td><td>邮箱</td><td>电话</td><td>爱好</td><td>操作</td>
		</tr>
		<s:iterator id="li" value="#request.totalUserList">
			<tr>
				<td><s:if test="#li!=null">
					<s:property value="user_id"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="user_name"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="user_nickname"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="user_sex"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="user_email"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="user_phone"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="user_hobby"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<a href="del!delUser?delUserId=<s:property value="user_id"/>">删除</a>
				</s:if></td>
			</tr>
		</s:iterator>
	</table>
  </body>
</html>
