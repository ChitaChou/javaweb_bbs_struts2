<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

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
	<s:if test="#session.currentUser.user_id != null">
		当前用户昵称:<s:property value="#session.currentUser.user_nickname"/> <a href="userLogout">退出</a>
	</s:if>
	<s:else>
		<a href="userLogin">登录</a>&nbsp;<a href="toRegister">注册</a>
	</s:else>
	&nbsp;<a href="testIndex">返回首页</a><br>
	<s:iterator id="li" value="#request.thread_Info">
		<h3 style="display: inline;">
			<s:if test="#li!=null">
				<title><s:property value="thread_title" />_帖子详情_Discovery生活社区</title>
				<s:property value="thread_title" />
			</s:if>
		</h3>
		发表时间:<s:property value="create_time" />&nbsp;作者:<s:property value="writer_id" />&nbsp;<h3 style="display: inline;"><a href="newReply?new_by_thread_id=<s:property value="thread_id" />&new_reply_writer_id=<s:property value="#session.currentUser.user_id"/>">回复</a></h3>
		<s:if test="#li!=null">
			<br><s:property value="thread_text" />
		</s:if>
		<br>
	</s:iterator>
	
	<s:iterator id="li2" value="#request.Reply_List">
			<s:if test="#li2!=null">
				<s:if test="second_reply_id != null">
					内容：<font color="red">回复<s:property value="second_reply_id" /></font>:<s:property value="reply_text" /> 作者：<s:property value="reply_writer_id" /> 回复时间：<s:property value="reply_time" />&nbsp;<a href="newReply2?new_by_thread_id=<s:property value="thread_id" />&new_reply_writer_id=<s:property value="#session.currentUser.user_id"/>&second_reply_id=<s:property value="reply_id" />">回复本楼</a><br>
				</s:if>
				<s:else>
					内容：<s:property value="reply_text" /> 作者：<s:property value="reply_writer_id" /> 回复时间：<s:property value="reply_time" />&nbsp;<a href="newReply2?new_by_thread_id=<s:property value="thread_id" />&new_reply_writer_id=<s:property value="#session.currentUser.user_id"/>&second_reply_id=<s:property value="reply_id" />">回复本楼</a><br>
				</s:else>
			</s:if>
	</s:iterator>
</body>
</html>
