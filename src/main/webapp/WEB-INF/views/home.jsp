<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html data-ng-app="goodxApp">
<head>
	<base href="/goodx/"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>WEB SITE</title>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/libs/bootstrap/css/bootstrap.min.css' />"></link>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/libs/bootstrap/css/bootstrap-theme.min.css' />"></link>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/lib/ngDialog/ngDialog.css' />"></link>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/lib/ngDialog/ngDialog-theme-default.css' />"></link>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/lib/ngDialog/ngDialog-theme-plain.css' />"></link>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/lib/ngDialog/ngDialog-custom-width.css' />"></link>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/hello.css' />"></link>
</head>
<body data-ng-controller="userController">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header clearfix">
				<a class="navbar-brand" href="#"> WEB SITE </a>
			</div>
			<nav data-ng-show="feedback.success == false">
				<ul class="nav nav-pills navbar-right">
					<li role="presentation"><a href="" data-ng-click="openSignup()">注册</a></li>
					<li role="presentation"><a href="" data-ng-click="openSignin()">登录</a></li>
					<li role="presentation"><a href="#">QQ登录</a></li>
					<li role="presentation"><a href="#">微信登录</a></li>
				</ul>
			</nav>
			<nav data-ng-show="feedback.success == true">
				<ul class="nav nav-pills navbar-right">
					<li role="presentation"><a href="" data-ng-click="switchToWrite()">发布</a></li>
					<li role="presentation"><a href="" data-ng-click="logout()">退出</a></li>
					<li role="presentation"><a href="#">{{feedback.message}}</a>
				</ul>
			</nav>
		</div>
	</nav>
	
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<div ng-view></div>
			</div>
			
			<div class="col-md-4">
				<div class="righthalf">
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="<c:url value='/resources/js/lib/jquery/jquery-1.12.1.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/jqueryui-1.11.4/jquery-ui.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/angular/angular.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/angular/angular-route.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/angular/angular-animate.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/plupload-2.1.8/js/moxie.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/plupload-2.1.8/js/plupload.dev.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/ui.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/qiniu/qiniu.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/ngDialog/ngDialog.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/angular-dragdrop/angular-dragdrop.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/ng-file-upload/ng-file-upload.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/ng-file-upload/ng-file-upload-shim.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/controllers/user.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/controllers/publish.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/directives/stepDisplay.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/directives/stepTemplate.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/upload.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/controllers/list.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/controllers/post.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/directives/stepBlock.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/services/session.js' />"></script>
</body>
</html>