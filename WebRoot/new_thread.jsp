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
    
    <title>Discovery生活社区_发表新主题帖</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/GeneralCSS.css">
  </head>
  
  <body>
  	<s:form action="publishNewThread" method="post" theme="simple">
  		<h1>发表新主题帖</h1>
  		<tr>
  			<td>所属板块ID：</td>
  			<td><input type="text" name="newThread.by_forum_id" value=<s:property value="#request.new_thread_forum_id"/> readonly="readonly"></td>
  			<td>作者ID：</td>
  			<td><input type="text" name="newThread.writer_id" value=<s:property value="#session.currentUser.user_id"/> readonly="readonly"></td>
  		</tr><br>
  		<tr>
  			<td>标题：</td>
  			<td><s:textarea name="newThread.thread_title" rows="1" cols="50"></s:textarea></td>
  			<td><font color="red"><s:property value="fieldErrors['title_error'][0]" /></font></td>
  		</tr></br>
  		<tr>
  			<td>内容：</td>
  			<td><s:textarea name="newThread.thread_text" rows="10" cols="70"></s:textarea></td>
  		</tr></br>
  		<tr>
  			<td><s:submit value="发布！" /></td>
  		</tr></br>
  	</s:form>
  </body>
</html>
