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

<title>用户注册</title>
<script type="text/javascript" src="JS/jquery-1.11.0.js"></script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/GeneralCSS.css">

</head>

<body>
	<div id="edit" align="center">
		<h1>用户注册</h1>
		<s:form action="create!createUser" method="post">
			<table>
				<tr>
					<td>用户名：</td>
					<td><font color="red">*</font></td>
					<td><input type="text" name="newUser.user_name" maxlength="20"></td>
					<td><font color="red"><s:property
								value="fieldErrors['username_error'][0]" /></font></td>
				</tr>
				<tr>
					<td>昵称：</td>
					<td><font color="red">*</font></td>
					<td><input type="text" name="newUser.user_nickname" maxlength="20"></td>
					<td><font color="red"><s:property
								value="fieldErrors['nickname_error'][0]" /></font></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><font color="red">*</font></td>
					<td><input type="password" name="newUser.user_password" maxlength="20"></td>
					<td><font color="red"><s:property
								value="fieldErrors['password_error'][0]" /></font></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><font color="red">*</font></td>
					<td><input type="password" name="newUser_confirm.user_password" maxlength="20"></td>
					<td><font color="red"><s:property
								value="fieldErrors['passwordCfm_error'][0]" /></font></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><font color="red">*</font></td>
					<td>男<input type="radio" name="newUser.user_sex" value="m">女<input
						type="radio" name="newUser.user_sex" value="f">未知<input
						type="radio" name="newUser.user_sex" value="unknown"></td>
					<td><font color="red"><s:property
								value="fieldErrors['sex_error'][0]" /></font></td>
				</tr>
				<tr>
					<td>邮件地址：</td>
					<td><font color="red">*</font></td>
					<td><input type="text" name="newUser.user_email"></td>
					<td></td>
				</tr>
				<tr>
					<td>电话：</td>
					<td><font color="red">*</font></td>
					<td><input type="text" name="newUser.user_phone"></td>
					<td></td>
				</tr>
				<tr>
					<td>爱好：</td>
				</tr>
			</table>
			<textarea rows="4" cols="50" name="newUser.user_hobby"></textarea>
			<input type="submit" value="注册">
		</s:form>
	</div>
</body>
</html>
