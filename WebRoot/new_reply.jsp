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
    
    <title>Discovery生活社区_回复帖子</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/GeneralCSS.css">
  </head>
  
  <body>
  	<s:form action="publishNewReply" method="post" theme="simple">
  		<h1>回复主题帖</h1>
  		<tr>
  			<td>所属帖子ID：</td>
  			<td><input type="text" name="newReply.by_thread_id" value=<s:property value="#request.new_by_thread_id"/> readonly="readonly"></td>
  			<td>作者ID：</td>
  			<td><input type="text" name="newReply.reply_writer_id" value=<s:property value="#session.currentUser.user_id"/> readonly="readonly"></td>
  		</tr><br>
  		<tr>
  			<td>回复内容：</td>
  			<td><s:textarea name="newReply.reply_text" rows="10" cols="70"></s:textarea></td>
  		</tr></br>
  		<tr>
  			<td><s:submit value="发布！" /></td>
  		</tr></br>
  	</s:form>
  </body>
</html>
