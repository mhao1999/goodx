/**
 * 
 */
'use strict';

angular.module('goodxApp')
.controller("listController", function($scope, $http, $location, session) {
	
	$scope.list = session.getList();
	
	$scope.getList = function() {
		$http.get(
			'list' 
		).success(function(data) {
			
			session.setList(data);;
			
			$scope.list = session.getList();
		})
	};
	
	$scope.getList();
	
	
	
	//$scope.$watchCollection('list', function(newValue, oldValue) {

	//	$scope.list = newValue;
	//});
});