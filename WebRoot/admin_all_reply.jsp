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
    
    <title>Discovery生活社区_全部回复_管理员控制面板</title>
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
    <h1>全部主题帖列表</h1>
    <table width="1300" height="256" border="1" cellpadding="1"
		cellspacing="1" align="center">
		<caption>List遍历-回复</caption>
		<tr>
		<td>回复ID</td><td>回帖人ID</td><td>所属主题帖</td><td>回复时间</td><td>回复内容</td><td>本条回复跟帖ID</td><td>操作</td>
		</tr>
		<s:iterator id="li" value="#request.totalReplyList">
			<tr>
				<td><s:if test="#li!=null">
					<s:property value="reply_id"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="reply_writer_id"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="by_thread_id"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="reply_time"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="reply_text"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="second_reply_id"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<a href="del!delReply?delReplyId=<s:property value="reply_id"/>">删除</a>
				</s:if></td>
			</tr>
		</s:iterator>
	</table>
  </body>
</html>
