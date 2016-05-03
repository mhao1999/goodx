/**
 * 
 */
'use strict';

angular.module('goodxApp')
.controller("listController", function($scope, $http, $location) {
	
	$scope.getList = function() {
		$http.get(
			'list' 
		).success(function(data) {
			$scope.list = data;
		})
	};
	
	$scope.getList();
});