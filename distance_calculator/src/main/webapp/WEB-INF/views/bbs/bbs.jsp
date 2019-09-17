<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BBS</title>
</head>
<body style="width:100%; height:100%;">
<%-- 	<c:forEach var="data" items="${data}" varStatus="status">
		<c:out value="${data.name}"/>
	</c:forEach> --%>
	<div style="border:1px solid black; width:80%; height:100%; margin:0 auto;">
		<div style="display:inline-block;width:10%">번호</div>
		<div style="display:inline-block;width:79%">제목</div>
		<div style="display:inline-block;width:10%">조회수</div>
	</div>
	<br/>
	<div style="width:80%; height:100%; margin:0 auto;">	
		<c:forEach var="data" items="${data}" varStatus="status">
			<div style="display:inline-block;width:10%;"><span style="cursor:pointer;" onclick="location.href='/bbs/${data.idx}'"><c:out value="${data.idx}"/></span></div>
			<div style="display:inline-block;width:79%;"><span style="cursor:pointer;" onclick="location.href='/bbs/${data.idx}'"><c:out value="${data.title}"/></span></div>
			<div style="display:inline-block;width:10%"><c:out value="${data.count}"/></div>
		</c:forEach>
	</div>
	<br/>
	<div style="width:80%; height:100%; margin:0 auto;">
		<div onclick="location.href='/bbs/write'" style="border:1px solid black;cursor:pointer;display:inline-block;float:right;width:10%">등록</div>
	</div>
</body>
</html>