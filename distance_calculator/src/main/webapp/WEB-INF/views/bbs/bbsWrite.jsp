<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote-bs4.min.js"></script>
<script type="text/javascript" src="/resources/js/bbs.js"></script>
<script type="text/javascript" src="/resources/js-lib/jquery.form.min.js"></script>
<head>
<meta charset="UTF-8">
<title>${title} - eljamdev</title>
</head>
<body style="width:100%; height:100%;">
	<div id="" style="width:80%; margin:0 auto;">
		<form id="writeForm" method="POST" enctype="multipart/form-data" accept-charset="UTF-8">
			<div>
				<input type="text" name="title" placeholder="제목" style="width:100%; margin:0 auto;"/>
			</div>
			</br>
			<textarea  id="summernote" name="contents" placeholder="내용" style="width:100%;height:80%"></textarea>
			</br>
				<input type="file" name="file" class="form-control-file" id="exampleFormControlFile1">
			</br> 
			<div id="write" class="btn btn-primary" style="float:right;">
				등록
			</div>
		</form>
	</div>
	<script>
	$(document).ready(function() {
		  $('#summernote').summernote({
			  placeholder: 'write your contents',
		        tabsize: 2,
		        height: 200,
		        minHeight: 200,
		        maxHeight: 500,
		        focus: false
		  });
	});
</script>
</body>
</html>