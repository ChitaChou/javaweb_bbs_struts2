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

<title>修改头像</title>

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
		当前用户昵称:<s:property value="#session.currentUser.user_nickname"/> <a href="pc!toPersonalCenterPage?pcUserId=<s:property value="#session.currentUser.user_id"/>">个人中心</a>&nbsp;<a href="userLogout">退出</a><br>
	</s:if>
	<s:else>
		<a href="userLogin">登录</a>&nbsp;<a href="toRegister">注册</a><br>
	</s:else>
  	
	<div id="edit">
    	<font style="size: 30px;">修改用户信息</font>
    	<font style="size: 20px;"><a href="allThread!toUserAllThread?pcUserId=<s:property value="#session.currentUser.user_id"/>">我的主题帖</a></font>
    	<font style="size: 20px;"><a href="allReply!toUserAllReply?pcUserId=<s:property value="#session.currentUser.user_id"/>">我的回复</a></font><br>
    	<font>头像编辑</font>
    	<s:form action="pc!editAvatar" method="post" enctype="multipart/form-data">	
		<s:iterator id="li" value="#request.edit_userAvatar">
			<s:if test="#li!=null">
				当前用户ID：<input type="text" name="editedUser1.user_id" value=<s:property value="user_id"/> readonly><br>
				当前用户头像：<img alt="用户头像" src=<s:property value="user_avatar_path"/>><br>
				上传新头像：<input name="upload" type="file" id="upload" />
				<input type="submit" name="Submit" value="提交" />
			</s:if>
		</s:iterator>
		</s:form>		
    </div>
</body>
</html>
