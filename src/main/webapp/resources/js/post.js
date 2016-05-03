/**
 * 
 */
'use strict';

angular.module('goodxApp')
.constant("imgDomain", "http://7xs539.com1.z0.glb.clouddn.com/")
.constant("imgViewSize", "?imageView2/1/w/300/h/300")
.controller("postController", function($scope, $http, $location) {
	
	$scope.getTopicDetail = function(topicId) {
		$http.get(
			'postDetail?id=' + topicId
		).success(function(data) {
			$scope.topic = data;
		})
	};
	
	$scope.getTopicDetail($scope.currentPost.id);
})
.directive('stepBlock', function(imgDomain, imgViewSize) {
	return {
		restrict: "E",
		link: function(scope, element, attrs) {

			if (scope.step.imgUrl) {
				var graphElem = angular.element("<div>").addClass("graph");
				var imgItm = angular.element('<img>');
				imgItm.attr("src", imgDomain + scope.step.imgUrl + imgViewSize);
				graphElem.append(imgItm);
				
				element.append(graphElem);
			}

			var contentElem = angular.element("<div>");
			contentElem.append(angular.element("<p>").text(scope.step.content));
			element.append(contentElem);
		}
	}
});