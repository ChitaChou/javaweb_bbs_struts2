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

<title>Discovery生活社区_首页</title>
<script type="text/javascript" src="JS/jquery-1.11.0.js"></script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="CSS/discovery_common.css">
</head>



<body>
	<div id="logo">
		<a href="testIndex"><img class="logo" alt="logo" src="PICS/Discovery-logo.png"></a>
	</div>
	<div id="umenu">
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
	</div>	
	<div id="searchbox" >
		<form action="search!toUserSearchResult" method="post">
		用户搜索
			<select name="condition">
				<option value="user_nickname">昵称</option>
				<option value="user_email">邮件地址</option>
			</select> <input type="text" name="content"> <input type="submit"
				value="搜索">
		</form>
	</div>

	<div class="content">
		<s:iterator id="li" value="#request.totalAreaList">
		<s:set name="AreaId" value="area_id"></s:set>
		<h3 style="display: inline;">
			<s:if test="#li!=null">
				<s:property value="area_name" />
			</s:if>
		</h3>
		<s:if test="#li!=null">
			<s:property value="area_desc" />
		</s:if>
		<br>
		<br>
		<s:iterator id="li2" value="#request.totalForumList">
			<s:set name="ByAreaId" value="by_area_id"></s:set>
			<s:if test="#li2!=null">
				<s:if test="#ByAreaId == #AreaId">
					<a
						href="forum!toForum?forum_id=<s:property value="forum_id" />&page=1&pageSize=10"><s:property
							value="forum_name" /></a>：<s:property value="forum_desc" />
					<br>
				</s:if>
			</s:if>
		</s:iterator>
		<br>
	</s:iterator>
	</div>
	<div id="footer">
		©2018 <a href="http://weibo.com/zzd1997">Chita Chou</a>. All Rights Reserved<br>
		致敬：<a href="http://www.hi-pda.com">Hi!PDA:来自D版带着爱</a>
	</div>
</body>
</html>
