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
    
    <title>Discovery生活社区_全部主题帖_管理员控制面板</title>
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
		<caption>List遍历-主题帖</caption>
		<tr>
		<td>帖子ID</td><td>发帖人ID</td><td>所属子版块</td><td>发帖时间</td><td>最后回复时间</td><td>标题</td><td>内容</td><td>操作</td>
		</tr>
		<s:iterator id="li" value="#request.totalThreadList">
			<tr>
				<td><s:if test="#li!=null">
					<s:property value="thread_id"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="writer_id"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="by_forum_id"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="create_time"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="latest_post_time"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="thread_title"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<s:property value="thread_text"/>
				</s:if></td>
				<td><s:if test="#li!=null">
					<a href="del!delThread?delThreadId=<s:property value="thread_id"/>">删除</a>
				</s:if></td>
			</tr>
		</s:iterator>
	</table>
  </body>
</html>
