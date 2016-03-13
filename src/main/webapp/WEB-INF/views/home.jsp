<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html data-ng-app="goodxApp">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>WEB SITE</title>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/lib/bootstrap/bootstrap.min.css' />"></link>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/lib/bootstrap/bootstrap-theme.min.css' />"></link>
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
					<li role="presentation"><a href="#">{{feedback.message}}</a>
				</ul>
			</nav>
		</div>
	</nav>
	
	<div class="container" data-ng-controller="publishController">
		<div class="row">
			<div class="col-md-8">
				<div class="lefthalf" data-ng-show="showHide.write == true">
					<div class="form-group">
						<label for="title">标题：</label>
						<input type="text" class="form-control" id="title">
					</div>
					
					<div class="ng-cloak">
						<ul>
							<li class="vthumbnail" data-ng-repeat="item in itmList" data-drop="true" data-drag="true" data-ng-model="itmList" data-jqyoui-droppable="{index: {{$index}}, onDrop: 'dropCallback'}" data-jqyoui-draggable="{index: {{$index}}, insertInline: true, direction:'jqyouiDirection'}" data-jqyoui-options="{revert: 'invalid'}" data-direction="{{item.jqyouiDirection}}">
								<div>
									<span>
										<div style="width: 50px;">
											上传照片
										</div>
									</span>
									<span>
										<textarea class="form-control" rows="8"></textarea>
									</span>
								</div>
							</li>
						</ul>
					</div>
				</div>
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
	<script type="text/javascript" src="<c:url value='/resources/js/lib/ngDialog/ngDialog.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/angular-dragdrop/angular-dragdrop.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/hello.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/publish.js' />"></script>
</body>
</html>