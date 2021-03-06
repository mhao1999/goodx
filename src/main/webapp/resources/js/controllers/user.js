'use strict';

angular.module('goodxApp', [ 'ngRoute', 'ngDialog', 'ngAnimate', 'ngDragDrop', 'ngFileUpload' ])
.config(function($routeProvider, $locationProvider) {
	
	$locationProvider.html5Mode({
		enabled: true,
		requireBase: true
	});
	
	$routeProvider.when("/list", {
		templateUrl: "static/postList.html"
	});
	
	$routeProvider.when("/create", {
		templateUrl: "static/create.html"
	});
	
	$routeProvider.when("/detail", {
		templateUrl: "static/postDetail.html"
	});
	
	$routeProvider.otherwise({
		templateUrl: "static/postList.html"
	});
})
.controller("userController", function($scope, $http, $location, ngDialog) {
	
	$scope.currentPost = {
		id : null	
	};
	
	$scope.form = {
		mode : 2,
		userName : "",
		emailAddress : "",
		password : "",
		gender : "",
		rememberMe : "",
		confirmPassword : ""
	};

	$scope.feedback = {
		success : false,
		message : null		
	};
	
	$scope.showHide = {
		write : false
	};
	
	$scope.setCurrentPostId = function(id) {
		$scope.currentPost.id = id;
		
		$location.path("/detail");
	}
	
	$scope.setMode = function (newValue) {
        $scope.form.mode = newValue;
    };

    $scope.isSignup = function () {
        return $scope.form.mode == 2;
    };

    $scope.isSignin = function () {
        return $scope.form.mode == 1;
    };
    
    $scope.switchToWrite = function() {
    	// $scope.showHide.write = true;
    	$location.path("/create");
    };

	$scope.createUser = function(signupForm) {
		var pass = $scope.form.password;
		var conf = $scope.form.confirmPassword;
		
		if (pass === conf)
		{
			$http({
				method : 'POST',
				url : 'signup',

				data : {
					userName : $scope.form.userName,
					email : $scope.form.emailAddress,
					password : $scope.form.password,
					gender : $scope.form.gender
				}
			}).success(function(data) {
				$scope.feedback = data;
				ngDialog.close();
			});
		} else {
			$scope.showValidation = true;
		}
	}
	
	$scope.signinUser = function(signinForm) {
		
		$http({
			method : 'POST',
			url : 'login',
			
			data : {
				userName : $scope.form.emailAddress,
				password : $scope.form.password,
				rememberMe : $scope.form.rememberMe
			}
		}).success(function(data) {
			$scope.feedback = data;
			
			ngDialog.close();
		})
	}
	
	$scope.preCloseCallbackOnScope = function(value) {
		if (value == "$document" || value == "$escape") {
			return false;
		}
		
		return true;
	}
	
	$scope.openSignup = function() {
		ngDialog.openConfirm({
			template: 'static/signup.html',
			preCloseCallback: 'preCloseCallbackOnScope',
			scope: $scope
		});
	}
	
	$scope.openSignin = function() {
		ngDialog.open({
			template: 'static/signin.html',
			preCloseCallback: 'preCloseCallbackOnScope',
			scope: $scope
		});
	}
	
	$scope.checkRememberMe = function() {
		$http({
			method : 'GET',
			url : 'checkRememberMe'
		}).success(function(data) {
			$scope.feedback = data;
		});
	}
	
	$scope.logout = function() {
		$http({
			method : 'POST',
			url : 'logout'
		});
	}
});

