<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/lib_import/taglib.jsp"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng nhập</title>
<link rel="stylesheet" href="/static/news/css/login.css">
</head>
<body>
	<form modelAttribute="u" action="dologin" method="get" id="login-form">
		<table>
		<tr>
			<div class="form-group">
				<td>UserName</td>
				<td><input type="text" value="" name="username" placeholder="userName" class="form-control"></td>
			</div>
		</tr>
		<tr><div class="form-group">
				<td>Password</td>
				<td><input type="password" value="" name="password" placeholder="Password" class="form-control"></td>
			</div>
		</tr>
		<tr>
			<td clospan="2"><input type="submit" value="login" class="btn" /></td>
		</tr>
		</table>
	<p>${mes}</p>
	<p>${u.getUsername() }</p>
	</form>
</body>
</html>