<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="/resources/js-lib/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/resources/js/bbs.js"></script>
<head>
<meta charset="UTF-8">
<title>BBS Write</title>
</head>
<body style="width:100%; height:100%;">
	<div id="" style="width:80%; margin:0 auto;">
		<form id="writeForm" method="POST">
			<div>
				<input type="text" name="title" placeholder="제목" style="width:100%; margin:0 auto;"/>
			</div>
			</br>
			<textarea name="contents" placeholder="내용" style="width:100%;height:80%"></textarea>
			</br>
			<div id="write" style="text-align:center;border:1px solid black;float:right;cursor:pointer;">
				등록
			</div>
		</form>
	</div>
</body>
</html>