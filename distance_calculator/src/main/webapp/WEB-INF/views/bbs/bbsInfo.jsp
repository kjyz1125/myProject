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
	<div style="width:80%; height:10%; margin:0 auto; border:1px solid black;">
		${data.title}
	</div>
	</br>
	<div style="width:80%; height:10%; margin:0 auto; border:1px solid black;">
		${data.contents}
	</div>
	<div style="width:80%; height:100%; margin:0 auto;">
		<div id="delete" style="border:1px solid black;cursor:pointer;display:inline-block;float:right;width:10%">삭제</div>
	</div>
	<div style="width:80%; height:100%; margin:0 auto;">
		<div onclick="javascript:location.href='/bbs/${data.idx}/update'" style="border:1px solid black;cursor:pointer;display:inline-block;float:right;width:10%">수정</div>
	</div>
	<div style="display:none;">
		${data.writer}
	</div>
	<div id="idx" style="display:none;" data="${data.idx}"></div>
</body>
</html>