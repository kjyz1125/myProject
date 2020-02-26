<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MAIN - eljamdev</title>
</head>
<body style="width:100%">
	<div class="row" style="position:absolute; width:80%; left:0;right:0; margin:0 auto; padding:10%">
		<c:forEach var="data" items="${list}" varStatus="status">
		<div style="padding:5px;">
			<div class="card" style="width: 17rem; padding:10px;">
			  <img class="card-img-top" src="/resources/img/thumbnail.jpg" alt="Card image cap">
			  <div class="card-body">
			    <h6 class="card-title underline cp toe" onclick="location.href='${data.notice}'+'${data.url}'"><c:out value="${data.title}"/></h6>
			    <p class="card-text" onclick="location.href='${data.notice}'+'${data.url}'"><c:out value="${data.name}"/></p>
			    <p class="card-text"><c:out value="${data.regdate}"/></p>
			    <!-- <a href="#" class="btn btn-primary">Go somewhere</a> -->
			  </div>
			</div>
		</div>
		</c:forEach>
	</div>
	<!-- <div class="card" style="position:absolute; width:80%; left:0;right:0; margin:0 auto">	
	</div> -->
</body>
</html>



<%-- <div style="width:250px; border:1px solid black; display:inline-block; text-align:center;">
				<span onclick="location.href='${data.notice}'+'${data.url}'"><c:out value="${data.title}"/></span>
				<span onclick="location.href='${data.notice}'+'${data.url}'"><c:out value="${data.name}"/></span>
				<span onclick="location.href='${data.notice}'+'${data.url}'"><c:out value="${data.count}"/></span>
			</div> --%>