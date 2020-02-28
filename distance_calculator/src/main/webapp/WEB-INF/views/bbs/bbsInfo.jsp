<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="/resources/js/bbs.js"></script>
<script type="text/javascript" src="/resources/js-lib/jquery.form.min.js"></script>
<head>
<meta charset="UTF-8">
<title>${title} - eljamdev</title>
</head>
<body style="width:100%; height:100%;">
	<div style="width:80%; height:20%; margin:0 auto;">
		<h1>
			<c:out value="${data.title}"/>
		</h1>
	</div>
	</br>
	<div style="width:80%; min-height:30%; margin:0 auto;">
		${data.contents}
	</div>

	<div style="width:80%; height:10%; margin:0 auto;">
		<form method="GET" id="downloadForm" action="/fileDownload.do">
			파일 : <span class="cp underline" onclick="fileDownload()">${data.real_file_name}</span>
			<input type="hidden" name="real_file_name" value="${data.real_file_name}"/>
			<input type="hidden" name="idx" value="${data.idx}"/>
		</form>
	</div>
	<div style="width:80%; height:auto; margin:0 auto;">
		<c:if test="${not empty name}">
			<c:if test="${name eq data.name}">
				<div class="btn btn-danger cp ml10" id="delete" style="display:inline-block;float:right;width:20%; max-width:80px;">삭제</div>
				<div class="btn btn-primary cp" onclick="javascript:location.href='/bbs/${data.idx}/update'" style="display:inline-block;float:right;width:20%; max-width:80px;">수정</div>
			</c:if>
		</c:if>
	</div>
	<div style="margin-top:10%"></div>
	<div id="idx" style="display:none;" data="${data.idx}"></div>
</body>
</html>