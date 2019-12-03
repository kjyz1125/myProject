<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="/resources/js-lib/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/resources/js/bbs.js"></script>
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
<head>
<meta charset="UTF-8">
<title>${title} - eljamdev</title>
</head>
<body style="width:100%; height:100%;">
	<div id="" style="width:80%; margin:0 auto;">
		<form id="writeForm" method="POST" enctype="multipart/form-data">
			<div>
				<input type="text" name="title" placeholder="제목" style="width:100%; margin:0 auto;"/>
			</div>
			</br>
			<textarea  id="summernote" name="contents" placeholder="내용" style="width:100%;height:80%"></textarea>
			</br>
			<div id="write" style="text-align:center;border:1px solid black;float:right;cursor:pointer;">
				등록
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