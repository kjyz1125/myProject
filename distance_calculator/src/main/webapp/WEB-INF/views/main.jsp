<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MAIN - eljamdev</title>
</head>
<body style="width:100%">
	<div class="row" style="position:absolute; width:80%; left:0;right:0; margin:0 auto; padding:5%">
		<c:forEach var="data" items="${list}" varStatus="status">
		<div style="padding:5px;">
			<div class="card" style="width: 17rem; padding:10px;">
			  <img class="card-img-top cp" src="/resources/img/thumbnail.jpg" onclick="location.href='${data.notice}'+'${data.url}'" alt="Card image cap">
			  <div class="card-body">
			    <h6 class="card-title underline cp toe" onclick="location.href='${data.notice}'+'${data.url}'"><c:out value="${data.title}"/></h6>
			    <p class="card-text" onclick="location.href='${data.notice}'+'${data.url}'"><c:out value="${data.name}"/></p>
			    <p class="card-text"><c:out value="${data.regdate}"/></p>
			 	<p class="card-text">조회수 : <c:out value="${data.count}"/></p>
			  </div>
			</div>
		</div>
		</c:forEach>
	</div>
</body>
</html>
