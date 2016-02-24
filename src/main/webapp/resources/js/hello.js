'use strict';

angular.module('goodxApp', [ 'ngRoute' ])
.controller("userController", function($scope, $http) {
	$scope.mode = 2;
	$scope.userName = "";
	$scope.emailAddress = "";
	$scope.password = "";
	$scope.confirmPassword = "";
	$scope.feedback = {};
	
	$scope.setMode = function (newValue) {
        $scope.mode = newValue;
    };

    $scope.isSignup = function () {
        return $scope.mode == 2;
    };

    $scope.isSignin = function () {
        return $scope.mode == 1;
    };

	$scope.createUser = function(signupForm) {
		var passmd5 = $scope.password;
		var confmd5 = $scope.confirmPassword;
		
		if (passmd5 === confmd5)
		{
			$http({
				method : 'POST',
				url : 'signup',

				data : {
					userName : $scope.userName,
					emailAddress : $scope.emailAddress,
					password : passmd5,
					confirmPassword : confmd5
				}
			}).success(function(data) {
				$scope.feedback.result = data;
			});
		} else {
			$scope.showValidation = true;
		}
	}
	
	$scope.queryUser = function(signinForm) {
		
		$http({
			method : 'POST',
			url : 'login',
			
			data : {
				userName : $scope.emailAddress,
				password : $scope.password,
				rememberMe : $scope.rememberMe
			}
		}).success(function(data) {
			$scope.dish = data;
		})
	}
});

