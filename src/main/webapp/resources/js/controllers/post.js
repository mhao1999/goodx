/**
 * 
 */
'use strict';

angular.module('goodxApp')
.controller("postController", function($scope, $http, $location) {
	
	$scope.getTopicDetail = function(topicId) {
		$http.get(
			'postDetail?id=' + topicId
		).success(function(data) {
			$scope.topic = data;
		})
	};
	
	$scope.getTopicDetail($scope.currentPost.id);
});