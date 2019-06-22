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

<title>用户个人中心</title>

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
    	<font color="red">ID与登录名不允许修改</font>
    	<s:form action="pc!editUser" method="post">	
		<s:iterator id="li" value="#request.edit_user">
			<s:if test="#li!=null">
				<s:set name="UserSex" value="user_sex"></s:set>
				当前用户ID：<input type="text" name="editedUser.user_id" value=<s:property value="user_id"/> readonly><br>
				当前登录名：<input type="text" name="editedUser.user_name" value=<s:property value="user_name"/> readonly><br>
				新昵称：<input type="text" name="editedUser.user_nickname" value=<s:property value="user_nickname"/>><br>
				性别：男<input type="radio" name="editedUser.user_sex" value="m" <s:if test='%{#UserSex == "男"}'>checked</s:if>>
				女<input type="radio" name="editedUser.user_sex" value="f" <s:if test='%{#UserSex == "女"}'>checked</s:if>>
				未知<input type="radio" name="editedUser.user_sex" value="unknown" <s:if test='%{#UserSex == "未知"}'>checked</s:if>><br>
				新邮箱：<input type="text" name="editedUser.user_email" value=<s:property value="user_email"/>><br>
				新手机号码：<input type="text" name="editedUser.user_phone" value=<s:property value="user_phone"/>><br>
				新爱好：<input type="text" name="editedUser.user_hobby" value=<s:property value="user_hobby"/>><br>
			<input type="submit" value="提交修改"><br/>
			</s:if>
		</s:iterator>
		</s:form>	
		<a href="pc!toUpdateAvatarPage?avatarUserId=<s:property value="#session.currentUser.user_id"/>">需要修改头像？</a><br>	
    </div>
</body>
</html>
