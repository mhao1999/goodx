/**
 * 
 */
'use strict';

angular.module('goodxApp')
.service('session', [function() {
	var list = [];
	
	this.addNew = function(newObj) {
		list.push(newObj);
		return list;
	};
	
	this.getList = function() {
		return list;
	};
	
	this.setList = function(newList) {
		list = newList;
		return list;
	}
	
	this.clear = function() {
		list = [];
		return list;
	}
}]);