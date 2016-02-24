<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>WEB SITE - 登录</title>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/lib/bootstrap.min.css' />"></link>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/lib/bootstrap-theme.min.css' />"></link>
	
    <style>
        .center {
            width: 935px;
            margin: 0 auto;
        }

		.lefthalf {
			width: 475px;
            height: 400px;
		}
		
		.righthalf {
			width: 420px;
		}
		
        .floatleft {
            float: left;
        }

        .clearfix:after {
            content: ".";
            display: block;
            height: 0;
            visibility: hidden;
            clear: both;
        }
    </style>
</head>
<body data-ng-app="goodxApp">
	<%
		Object message = request.getAttribute("message");
		if (message != null)
			out.println(message.toString());
	%>

	<div id="signup_container" data-ng-controller="userController">
		<div class="center" data-ng-hide="feedback.result">
			<div style="height: 40px;"></div>
			<div class="floatleft lefthalf"></div>
			<div id="signup" class="floatleft righthalf"
				data-ng-show="isSignup()">
				<form name="signupForm" style="margin-left: 80px;"
					novalidate="novalidate" data-ng-submit="createUser(signupForm)">
					<div class="well">
						<div class="form-group">
							<label for="userName">用 户 名:</label> <input type="text"
								class="form-control" id="userName" name="userName" value=""
								data-ng-model="userName" required="required" />
						</div>
						<div class="form-group">
							<label for="emailAddress">邮 箱:</label> <input type="email"
								class="form-control" id="emailAddress" name="emailAddress"
								value="" data-ng-model="emailAddress" required="required" />
						</div>
						<div class="form-group">
							<label for="password">输入密码:</label> <input type="password"
								class="form-control" id="password" name="password" value=""
								data-ng-model="password" required="required" />
						</div>
						<div class="form-group">
							<label for="confirmPassword">确认密码:</label> <input type="password"
								class="form-control" id="confirmPassword" name="confirmPassword"
								value="" data-ng-model="confirmPassword" required="required" />
						</div>
						<div class="error" data-ng-show="showValidation">密码不一致！</div>

						<button type="submit" class="btn btn-primary btn-block">注册</button>
						<div>
							<p>
								已有账户？请<a data-ng-click="setMode(1)">登录<i
									class="icon-circle-arrow-right"></i></a>
							</p>
						</div>
					</div>
				</form>
			</div>
			<div id="signin" class="floatleft righthalf"
				data-ng-show="isSignin()">
				<form name="loginform" style="margin-left: 80px;"
					novalidate="novalidate" action="" method="post">
					<div class="well">
						<div class="form-group">
							<label for="emailAddress">邮 箱:</label> <input type="email"
								class="form-control" id="emailAddress" name="username" value=""
								data-ng-model="emailAddress" required="required" />
						</div>
						<div class="form-group">
							<label for="password">密 码:</label> <input type="password"
								class="form-control" id="password" name="password" value=""
								data-ng-model="password" required="required" />
						</div>
						<div class="form-group">
							<label for="rememberMe">记住我</label>
							<input type="checkbox" class="form-control" id="rememberMe" name="rememberMe" value="" 
								data-ng-model="rememberMe" required="required" />
						</div>
						<button type="submit" class="btn btn-primary btn-block">登录</button>
						<div>
							<p>
								还没有账户？请<a data-ng-click="setMode(2)">注册<i
									class="icon-circle-arrow-right"></i></a>
							</p>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<script type="text/javascript" src="<c:url value='/resources/js/lib/angular.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/angular-route.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/hello.js' />"></script>
</body>
</html>