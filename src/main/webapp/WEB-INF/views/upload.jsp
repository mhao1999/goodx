<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>七牛云存储 - JavaScript SDK</title>
	<link rel="shortcut icon" href="<c:url value='/resources/images/favicon.ico' />"></link>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/libs/bootstrap/css/bootstrap.min.css' />"></link>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/main.css' />"></link>
	<link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/highlight.css' />"></link>
</head>
<body>
	<div class="container">
		<div class="text-left col-md-12 wrapper">
		</div>
		<div class="body">
			<div class="col-md-12">
				<div id="container">
					<a class="btn btn-default btn-lg " id="pickfiles" href="#"> <i
						class="glyphicon glyphicon-plus"></i> <span>选择文件</span>
					</a>
				</div>
			</div>

			<div style="display: none" id="success" class="col-md-12">
				<div class="alert-success">队列全部文件处理完毕</div>
			</div>
			<div class="col-md-12 ">
				<table class="table table-striped table-hover text-left"
					style="margin-top: 40px; display: none">
					<thead>
						<tr>
							<th class="col-md-4">Filename</th>
							<th class="col-md-2">Size</th>
							<th class="col-md-6">Detail</th>
						</tr>
					</thead>
					<tbody id="fsUploadProgress">
					</tbody>
				</table>
			</div>
		</div>
		<div class="modal fade body" id="myModal-img" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">图片效果查看</h4>
					</div>
					<div class="modal-body">
						<div class="modal-body-wrapper text-center">
							<a href="" target="_blank"> <img src="" alt="" data-key=""
								data-h="">
							</a>
						</div>
						<div class="modal-body-footer">
							<div class="watermark">
								<span>水印控制：</span> <a href="#" data-watermark="NorthWest"
									class="btn btn-default"> 左上角 </a> <a href="#"
									data-watermark="SouthWest" class="btn btn-default"> 左下角 </a> <a
									href="#" data-watermark="NorthEast" class="btn btn-default">
									右上角 </a> <a href="#" data-watermark="SouthEast"
									class="btn btn-default disabled"> 右下角 </a> <a href="#"
									data-watermark="false" class="btn btn-default"> 无水印 </a>
							</div>
							<div class="imageView2">
								<span>缩略控制：</span> <a href="#" data-imageview="large"
									class="btn btn-default disabled"> 大缩略图 </a> <a href="#"
									data-imageview="middle" class="btn btn-default"> 中缩略图 </a> <a
									href="#" data-imageview="small" class="btn btn-default">
									小缩略图 </a>
							</div>
							<div class="imageMogr2">
								<span>高级控制：</span> <a href="#" data-imagemogr="left"
									class="btn btn-default no-disable-click"> 逆时针 </a> <a href="#"
									data-imagemogr="right" class="btn btn-default no-disable-click">
									顺时针 </a> <a href="#" data-imagemogr="no-rotate"
									class="btn btn-default"> 无旋转 </a>
							</div>
							<div class="text-warning">备注：小图片水印效果不明显，建议使用大图片预览水印效果</div>
						</div>
					</div>
					<div class="modal-footer">
						<span class="pull-left">本示例仅演示了简单的图片处理效果，了解更多请点击</span> <a
							href="https://github.com/SunLn/qiniu-js-sdk" target="_blank"
							class="pull-left">本SDK文档</a> <span class="pull-left">或</span> <a
							href="http://developer.qiniu.com/docs/v6/api/reference/fop/image/"
							target="_blank" class="pull-left">七牛官方文档</a>

						<button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="<c:url value='/resources/js/lib/jquery/jquery-1.12.1.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/libs/bootstrap/js/bootstrap.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/plupload-2.1.8/js/moxie.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/plupload-2.1.8/js/plupload.dev.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/plupload-2.1.8/js/i18n/zh_CN.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/ui-demo.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/lib/qiniu/qiniu.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/highlight.js' />"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/main.js' />"></script>
</body>
</html>