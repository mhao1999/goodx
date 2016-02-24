<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>WEB SITE</title>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/lib/bootstrap.min.css' />"></link>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header clearfix">
			<a class="navbar-brand" href="#"> WEB SITE </a>
		</div>
		<nav>
			<ul class="nav nav-pills navbar-right">
				<li role="presentation"><a href="#">发布</a></li>
				<li role="presentation"><a href="#">注册</a></li>
				<li role="presentation"><a href="<c:url value='/login.jsp' />">登录</a></li>
				<li role="presentation"><a href="#">QQ登录</a></li>
				<li role="presentation"><a href="#">微信登录</a></li>
			</ul>
		</nav>
	</div>
	</nav>
	
	
	<script type="text/javascript" src="<c:url value='/resources/js/lib/angular.min.js' />"></script>
</body>
</html>