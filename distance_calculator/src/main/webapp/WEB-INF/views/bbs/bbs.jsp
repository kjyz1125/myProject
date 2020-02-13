<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title} - eljamdev</title>
<script type="text/javascript" src="/resources/js-lib/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/resources/js/bbs.js"></script>
</head>
<body style="width:100%; height:100%;">
<article>
	<div class="container">
		<div class="table-responsive">
	<div style="border:1px solid black; width:80%;  margin:0 auto;">
		<div style="display:inline-block;width:10%">번호</div>
		<div style="display:inline-block;width:58%">제목</div>
		<div style="display:inline-block;width:19%">작성자</div>
		<div style="display:inline-block;width:10%">조회수</div>
	</div>
	<br/>
	<div style="width:80%; margin:0 auto;">
	<c:if test="${empty data}">
		<div style="display:inline-block;width:100%;text-align:center;">
			등록된 게시물이 없습니다.
		</div>
	</c:if>
		<c:forEach var="data" items="${data}" varStatus="status">
			<div style="display:inline-block;width:10%;"><span style="cursor:pointer;" onclick="location.href=location.pathname+'/${data.idx}'"><c:out value="${(count-pagination.startList)-status.index}"/></span></div>
			<div style="display:inline-block;width:58%;"><span class="underline" style="cursor:pointer;" onclick="location.href=location.pathname+'/${data.idx}'"><c:out value="${data.title}"/></span></div>
			<div style="display:inline-block;width:19%;"><span style="cursor:pointer;" onclick="location.href=location.pathname+'/${data.idx}'"><c:out value="${data.writer}"/></span></div>
			<div style="display:inline-block;width:10%"><c:out value="${data.count}"/></div>
		</c:forEach>
		
	</div>
	<br/>
	
	<!-- pagination{s} -->
	<div id="paginationBox" style="width:80%; margin:0 auto;">
		<ul class="pagination" style="width:50%;">
			<c:if test="${pagination.prev}">
				<li class="page-item"><a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a></li>
			</c:if>

			<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
				<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> "><a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> ${idx} </a></li>
			</c:forEach>

			<c:if test="${pagination.next}">
				<li class="page-item"><a class="page-link" href="#" onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')" >Next</a></li>
			</c:if>
		</ul>
		<ul class="pagination" style="width:50%;">
			<li class="page-item">
				<c:if test="${not empty name}">
					<a class="page-link" href="#" onclick="location.href= location.pathname + '/write'" style="float:right;">등록</a>
				</c:if>
			</li>
		</ul>
	</div>
	<!-- pagination{e} -->
	
	<!-- search{s} -->
	<div class="form-group row justify-content-center" style="width:80%; margin:0 auto;">
		<div class="w100" style="padding-right:10px">
			<select class="form-control form-control-sm" name="searchType" id="searchType">
				<option value="title">제목</option>
				<option value="contents">본문</option>
				<option value="writer">작성자</option>
			</select>
		</div>
		<div class="w300" style="padding-right:10px">
			<input type="text" class="form-control form-control-sm" name="keyword" placeholder="검색어입력" value="${search.keyword}" id="keyword">
		</div>
		<div>
			<button class="btn btn-sm btn-primary" name="btnSearch" id="search">검색</button>
		</div>
	</div>
		<!-- search{e} -->
	</div>
	</div>
	</article>
</body>
</html>