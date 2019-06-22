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
<script type="text/javascript" src="JS/jquery-1.11.0.js"></script>

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
	<script type="text/javascript">
		$(function(){
			$("tr:even").css("background","yellow");
		});
	</script>
	<s:if test="#session.currentUser.user_id != null">
		当前用户昵称:<s:property value="#session.currentUser.user_nickname"/> <a href="userLogout">退出</a>
	</s:if>
	<s:else>
		<a href="userLogin">登录</a>&nbsp;<a href="toRegister">注册</a>
	</s:else>
	&nbsp;<a href="testIndex">返回首页</a><br>
	<s:iterator id="li" value="#request.forum_Info">
		<h3 style="display: inline;">
			<s:if test="#li!=null">
				<title><s:property value="forum_name" />_板块首页_Discovery生活社区</title>
				<s:property value="forum_name" />
			</s:if>
		</h3>
		<s:if test="#li!=null">
			<s:property value="forum_desc" />
		</s:if>
		当前主题帖数：<s:property value="#request.threads_Num" />
		<a href="newThread?new_thread_forum_id=<s:property value="forum_id" />&new_thread_writer_id=<s:property value="#session.currentUser.user_id"/>"><h3 style="display: inline;">发表新主题帖</h3></a>
		<br>
	</s:iterator>
	<table align="center" style="width:90%;">
		<tr>
			<td>标题</td>
			<td>作者</td>
			<td>发帖时间</td>
			<td>最后回复</td>
		</tr>
		<s:iterator id="li2" value="#request.threads_List">
			<s:if test="#li2!=null">
				<tr>
					<td><a href="thread!toThread?thread_id=<s:property value="thread_id" />"><s:property value="thread_title" /></a></td>
					<td><s:property value="writer_id" /></td>
					<td><s:property value="create_time" /></td>
					<td><s:property value="latest_post_time" /></td>
				</tr>
			</s:if>
	</s:iterator>
	</table>
	
		<s:bean name="org.apache.struts2.util.Counter" id="counter">
			<s:param name="first" value="1" />
    		<s:param name="last" value="#request.pageNumber" />
    		默认每页显示10条主题帖&nbsp;
    		每页显示条数:
    		<select name="pageSize" onchange="changepagesize(this.value)">
  				<option value="10" <s:if test="#request.pageSize == 10">selected</s:if>>10</option>
  				<option value="5" <s:if test="#request.pageSize == 5">selected</s:if>>5</option>
  				<option value="3" <s:if test="#request.pageSize == 3">selected</s:if>>3</option>
  			</select></br>
  			页码:
    		<s:iterator>
    			<a href="forum!toForum?forum_id=<s:property value="forum_id" />&page=<s:property/>&pageSize=<s:property value="#request.pageSize" />"><s:property/></a>		
    		</s:iterator>
 		</s:bean>
	<script type="text/javascript">
		function changepagesize(val){
			window.location.href="forum!toForum?forum_id=<s:property value="forum_id" />&page=1&pageSize="+val;
		}
	</script>
</body>
</html>
