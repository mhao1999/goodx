/**
 * 
 */
'use strict';

angular.module('goodxApp')
.controller("publishController", function($scope, $http, $location) {
	
	$scope.data = {
			subject: null,
			steps: [
			    { 'order': '1', 'imgUrl': '', 'content': '' },
			    { 'order': '2', 'imgUrl': '', 'content': '' },
			    { 'order': '3', 'imgUrl': '', 'content': '' }
			]
	};
	
	$scope.upToken = {};

	$scope.dropCallback = function(event, ui) {
		for (var i = 0; i < $scope.data.steps.length; i++) {
			$scope.data.steps[i].order = i + 1;
		}
	};
	
	$scope.resort = function() {
		for (var i = 0; i < $scope.data.steps.length; i++) {
			$scope.data.steps[i].order = i + 1;
		}
	}
	
	$scope.addStep = function() {
		var count = $scope.data.steps.length;
	
		$scope.data.steps.push({'order': count + 1, 'imgUrl': '', 'content': ''})
	};
	
	$scope.addWidget = function(index) {
		$scope.data.steps.splice(index + 1, 0, {});
		
		$scope.resort();
	};
	
	$scope.removeWidget = function(index) {
		$scope.data.steps.splice(index, 1);
		
		$scope.resort();
	};
	
	$scope.moveUp = function(index) {
		if (index != 0) {
			var a = $scope.data.steps[index];
			var b = $scope.data.steps[index - 1];
			$scope.data.steps[index] = b;
			$scope.data.steps[index - 1] = a;
			
			$scope.resort();
		}
	};
	
	$scope.moveDown = function(index) {
		if (index != $scope.data.steps.length - 1) {
			var a = $scope.data.steps[index];
			var b = $scope.data.steps[index + 1];
			$scope.data.steps[index] = b;
			$scope.data.steps[index + 1] = a;
			
			$scope.resort();
		}
	};
	
	/*
	$scope.upload = function(file) {
		$scope.imgs.f = file;
		
		if (file) {
			file.upload = Upload.upload({
				url: 'upload',
				file: file
			}).progress(function (evt) {
				var progressPercentage = parseInt(100.0 * evt.loaded /evt.total);
				console.log('progress: ' + progressPercentage + '% ' + evt.config.file.name);
			}).success(function(data, status, headers, config) {
				console.log('file ' + config.file.name + 'uploaded. Response: ' + data);
			});
		}
	};
	*/
	
	$scope.addNew = function() {
		$http.post(
			'publish',
			$scope.data
		).success(function(data) {
			$location.path("list");
		});
	};
	
	$scope.getToken = function() {
		return $http.get('token').then(function(response) {
			$scope.upToken = response.data;
		});
	};

});