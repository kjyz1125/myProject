<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="/resources/js-lib/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/resources/js/bbs.js"></script>
<head>
<meta charset="UTF-8">
<title>BBS info</title>
</head>
<body style="width:100%; height:100%;">
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
</body>
</html>