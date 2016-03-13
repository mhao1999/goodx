'use strict';

angular.module('goodxApp')
.controller("publishController", function($scope) {
	$scope.itmList = [
	    { 'title': 'one', 'order': '1', 'drag': true },
	    { 'title': 'two', 'order': '2', 'drag': true },
	    { 'title': 'three', 'order': '3', 'drag': true }
	];
	
	$scope.dropCallback = function(event, ui) {
		for (var i = 0; i < $scope.itmList.length; i++) {
			$scope.itmList[i].order = i;
		}
	};
});