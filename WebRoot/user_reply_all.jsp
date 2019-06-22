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

<title>我的回复</title>

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
	<a href="testIndex"><h1 style="display: inline;">测试首页</h1></a>&nbsp;
	<s:if test="#session.currentUser.user_id != null">
		当前用户昵称:<s:property value="#session.currentUser.user_nickname" />
		<a
			href="pc!toPersonalCenterPage?pcUserId=<s:property value="#session.currentUser.user_id"/>">个人中心</a>&nbsp;<a
			href="userLogout">退出</a>
		<br>
	</s:if>
	<s:else>
		<a href="userLogin">登录</a>&nbsp;<a href="toRegister">注册</a>
		<br>
	</s:else>

		<font style="size: 30px;"><a href="pc!toPersonalCenterPage?pcUserId=<s:property value="#session.currentUser.user_id"/>">修改用户信息</a></font>
    	<font style="size: 20px;"><a href="allThread!toUserAllThread?pcUserId=<s:property value="#session.currentUser.user_id"/>">我的主题帖</a></font>
    	<font style="size: 20px;">我的回复</font><br>
		<s:iterator id="li" value="#request.user_reply">
			<s:if test="second_reply_id != null">
					内容：<font color="red">回复<s:property value="second_reply_id" /></font>:<s:property value="reply_text" /> 作者：<s:property value="reply_writer_id" /> 回复时间：<s:property value="reply_time" /><br>
				</s:if>
				<s:else>
					内容：<s:property value="reply_text" /> 作者：<s:property value="reply_writer_id" /> 回复时间：<s:property value="reply_time" /><br>
				</s:else>
		</s:iterator>

	
</body>
</html>
