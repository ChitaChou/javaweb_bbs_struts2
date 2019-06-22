<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>编辑信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/GeneralCSS.css">

  </head>
  
  <body>
  <!-- 此页面为用户信息修改页面 -->
    <div id="edit">
    	<h1>修改管理员信息</h1>
    	<font color="red">因管理员账户特殊权限原因，ID与昵称不允许修改</font>
    	<s:form action="edit!editAdmin" method="post">	
		<s:iterator id="li" value="#request.edit_admin">
			<s:if test="#li!=null">
				当前管理员ID：<input type="text" name="editedAdmin.admin_id" value=<s:property value="admin_id"/> readonly><br>
				新管理员昵称：<input type="text" name="editedAdmin.admin_name" value=<s:property value="admin_name"/> readonly><br>
				新管理员密码：<input type="password" name="editedAdmin.admin_password" value=<s:property value="admin_password"/> ><br>
				新邮件地址：<input type="text" name="editedAdmin.admin_email" value=<s:property value="admin_email"/> ><br>
			<input type="submit" value="提交修改"><br/>
			</s:if>
		</s:iterator>
		</s:form>
    </div>
  </body>
</html>
