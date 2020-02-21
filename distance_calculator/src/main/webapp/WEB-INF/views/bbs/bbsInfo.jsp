<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="/resources/js-lib/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/resources/js/bbs.js"></script>
<head>
<meta charset="UTF-8">
<title>${title} - eljamdev</title>
</head>
<body style="width:100%; height:100%;">
	<div style="width:80%; margin:0 auto;">
		<h1>
			<c:out value="${data.title}"/>
		</h1>
	</div>
	</br>
	<div style="width:80%; margin:0 auto;">
		${data.contents}
	</div>
	<div style="width:80%; height:auto; margin:0 auto;">
		<c:if test="${not empty name}">
			<c:if test="${name eq data.name}">
				<div id="delete" style="border:1px solid black;cursor:pointer;display:inline-block;float:right;width:10%">삭제</div>
				<div onclick="javascript:location.href='/bbs/${data.idx}/update'" style="border:1px solid black;cursor:pointer;display:inline-block;float:right;width:10%">수정</div>
			</c:if>
		</c:if>
	</div>
	<div id="idx" style="display:none;" data="${data.idx}"></div>
</body>
</html>