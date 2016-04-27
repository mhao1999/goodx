'use strict';

angular.module('goodxApp')
.controller("publishController", function($scope, $http) {
	
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

})
.directive('stepDisplay', function($compile) {
	return {
		templateUrl: 'static/addstep.html'
	}
})
.directive('stepTemplate', function() {
	return {
		restrict: "A",
		scope: true,
		link: {
			pre: function(scope, elem, attr) {
				scope.containerId = "container" + scope.$index;
				scope.stepId = 'pickfiles' + scope.$index;
				scope.progressId = 'fsUploadProgress' + scope.$index;
				elem.attr("id", scope.containerId);
				elem.find(".uil").attr("id", scope.stepId);
			},
			post: function(scope, elem, attr) {
				
				scope.option = {
						runtimes: 'html5,flash,html4',
						browse_button: scope.stepId,
						container: scope.containerId,
						drop_element: scope.containerId,
						max_file_size: '100mb',
						flash_swf_url: 'plupload-2.1.8/js/Moxie.swf',
						dragdrop: true,
						chunk_size: '4mb',
						uptoken_url: 'token.json',
						domain: 'http://7xs539.com1.z0.glb.clouddn.com/',
						get_new_uptoken: false,
						unique_names: true,
						auto_start: true,
						log_level: 5,
						init: {
							'FilesAdded': function(up, files) {
								elem.children(".uil,.uii,.uin,.uic").hide();
								elem.children(".uploading").show();
								plupload.each(files, function(file) {
									var progress = new FileProgress(file, scope.progressId);
									progress.setStatus("等待...");
									progress.bindUploadCancel(up);
								});
							},
							'BeforeUpload': function(up, file) {
								var progress = new FileProgress(file, scope.progressId);
								var chunk_size = plupload.parseSize(this.getOption("chunk_size"));
								if (up.runtime === "html5" && chunk_size) {
									progress.setChunkProgess(chunk_size);
								}
							},
							'UploadProgress': function(up, file) {
								var progress = new FileProgress(file, scope.progressId);
				                var chunk_size = plupload.parseSize(this.getOption('chunk_size'));
				                progress.setProgress(file.percent + "%", file.speed, chunk_size);
							},
							'UploadComplete': function() {
								
							},
							'FileUploaded': function(up, file, info) {
								elem.children(".uil,.uii,.uin,.uic").show();
								elem.children().find(".foo").hide();
								elem.children(".uploading").hide();
								var res = $.parseJSON(info);
								var url;
								if (res.url) {
									url = res.url;
								} else {
									var domain = up.getOption('domain');
									url = domain + encodeURI(res.key);
								}
								
								var imageView = '?imageView2/1/w/140/h/80';

							    var isImage = function(url) {
							        var res, suffix = "";
							        var imageSuffixes = ["png", "jpg", "jpeg", "gif", "bmp"];
							        var suffixMatch = /\.([a-zA-Z0-9]+)(\?|\@|$)/;

							        if (!url || !suffixMatch.test(url)) {
							            return false;
							        }
							        res = suffixMatch.exec(url);
							        suffix = res[1].toLowerCase();
							        for (var i = 0, l = imageSuffixes.length; i < l; i++) {
							            if (suffix === imageSuffixes[i]) {
							                return true;
							            }
							        }
							        return false;
							    };
							    
							    var isImg = isImage(url);
							    
							    var Wrapper = $('<div class="Wrapper"/>');
							    var imgWrapper = $('<div class="imgWrapper"/>');
							    var linkWrapper = $('<a class="linkWrapper" target="_blank"/>');
							    var showImg = $('<img src="static/images/loading.gif"/>');
							    
							    elem.children(".uil").append(Wrapper);
							    
							    if (!isImg) {
							        showImg.attr('src', 'static/images/default.png');
							        Wrapper.addClass('default');

							        imgWrapper.append(showImg);
							        Wrapper.append(imgWrapper);
							    } else {
							        linkWrapper.append(showImg);
							        imgWrapper.append(linkWrapper);
							        Wrapper.append(imgWrapper);

							        var img = new Image();
							        if (!/imageView/.test(url)) {
							            url += imageView
							        }
							        $(img).attr('src', url);

							        var height_space = 340;
							        $(img).on('load', function() {
							            showImg.attr('src', url);

							            linkWrapper.attr('href', url).attr('title', '查看原图');

							            function initImg(url, key, height) {
							                $('#myModal-img').modal();
							                var modalBody = $('#myModal-img').find('.modal-body');
							                if (height <= 300) {
							                    $('#myModal-img').find('.text-warning').show();
							                }
							                var newImg = new Image();
							                modalBody.find('img').attr('src', 'static/images/loading.gif');
							                newImg.onload = function() {
							                    modalBody.find('img').attr('src', url).data('key', key).data('h', height);
							                    modalBody.find('.modal-body-wrapper').find('a').attr('href', url);
							                };
							                newImg.src = url;
							            }

							        }).on('error', function() {
							            showImg.attr('src', 'default.png');
							            Wrapper.addClass('default');
							        });
							    }
							    
								//var progress = new FileProgress(file, scope.stepId);
								//progress.setComplete(up, info);
							},
							'Error': function(up, err, errTip) {
								$('table').show();
								var progress = new FileProgress(err.file, scope.progressId);
								progress.setError();
								progress.setStatus(errTip);
							}
						}
					};
				var qiniu = new QiniuJsSDK();
				var uploader = qiniu.uploader(scope.option);
			}
		}
	}
});