<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<!-- include summernote css/js -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
<head>
<meta charset="UTF-8">
<title>${title} - eljamdev</title>
</head>
<%-- <body style="width:100%; height:100%;">
	<div style="width:100%; height:100%; margin:0 auto;">
		<form id="writeForm" method="POST">
			<input type="text" name="title" style="width:80%; height:10%; margin:0 auto;" value="${data.title}" placeholder="제목">
			</br>
			<textarea name="contents" style="width:80%; height:10%; margin:0 auto;" placeholder="내용">${data.contents}</textarea>
			<div style="width:80%; height:100%; margin:0 auto;">
				<div id="update" style="border:1px solid black;cursor:pointer;display:inline-block;float:right;width:10%">수정</div>
			</div>
			<div style="display:none;">
				<input type="text" name="writer" readonly="readonly" value="${data.writer}">
				<input type="text" name="idx" readonly="readonly" value="${data.idx}">
			</div>
		</form>
	</div>
</body> --%>
<body style="width:100%; height:100%;">
	<div id="" style="width:80%; margin:0 auto;">
		<form id="writeForm" method="POST" enctype="multipart/form-data">
			<div>
				<input type="text" name="title" placeholder="제목" value="${data.title}" style="width:100%; margin:0 auto;"/>
			</div>
			</br>
			<textarea  id="summernote" name="contents" placeholder="내용" style="width:100%;height:80%">
				${data.contents}
			</textarea>
			<div id="update" style="border:1px solid black;cursor:pointer;display:inline-block;float:right;width:10%">수정</div>
			<div style="display:none;">
				<input type="text" name="idx" readonly="readonly" value="${data.idx}">
			</div>
		</form>
	</div>
</body>
<script>
	$(document).ready(function() {
		  $('#summernote').summernote({
			  placeholder: 'write your contents',
		        tabsize: 2,
		        height: 200,
		        minHeight: 200,
		        maxHeight: 500,
		        focus: true
		  });
		  
		  
	});
</script>
</html>