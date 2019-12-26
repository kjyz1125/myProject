<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<head>
	<script type="text/javascript" src="/resources/js-lib/jquery-3.3.1.js"></script>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
	<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/reset.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
	<script type="text/javascript" src="/resources/js/main.js"></script>
</head>
<h1>
NOW MAINTENANCE
</h1>
<body style="width:100%; margin-bottom:10px;">
	<div style="margin:0 auto; width:90%; height:10%; background-color:black;">
 	<div style="margin:0 auto; color:white;">
		<div class="menu" data="" style="float:left; width:10%; height:100%; padding:1px; border:1px solid white;display:table;cursor:pointer;">
			<span style="display:table-cell;text-align:center;vertical-align:middle;">HOME</span>
		</div>
		<div class="menu" data="bbs" style="float:left; width:10%; height:100%; padding:1px; border:1px solid white;display:table;cursor:pointer;">
			<span style="display:table-cell;text-align:center;vertical-align:middle;">bbs</span>
		</div>
		<div class="menu" data="devOps" style="float:left; width:10%; height:100%; padding:1px; border:1px solid white;display:table;cursor:pointer;">
			<span style="display:table-cell;text-align:center;vertical-align:middle;">DevOps</span>
		</div>
		<div class="menu" data="github" style="float:left; width:10%; height:100%; padding:1px; border:1px solid white;display:table;cursor:pointer;">
			<span style="display:table-cell;text-align:center;vertical-align:middle;">github</span>
		</div>
		<div class="menu" data="jenkins" style="float:left; width:10%; height:100%; padding:1px; border:1px solid white;display:table;cursor:pointer;">
			<span style="display:table-cell;text-align:center;vertical-align:middle;">jenkins</span>
		</div>
		<c:choose>
		    <c:when test="${not empty name}">
		        <div class="menu" data="" style="float:right; width:10%; height:100%; padding:1px; border:1px solid white;display:table;cursor:pointer;">
					<span style="display:table-cell;text-align:center;vertical-align:middle;" onclick="ajaxLogout()">LOGOUT</span>
				</div> 
		    </c:when>
		    <c:otherwise>
				<div class="menu" data="login" style="float:right; width:10%; height:100%; padding:1px; border:1px solid white;display:table;cursor:pointer;">
					<span style="display:table-cell;text-align:center;vertical-align:middle;">LOGIN</span>
				</div>
		    </c:otherwise>                  
		</c:choose> 
	</div>
</div>
</body>
<div style="width:100%; margin-bottom:5%;">
</div>
<div id="loginPopup" style="background-color:black;position:absolute;width:30%;height:30%;top:300px;left:300px;z-index:9999;display:none;">
	<form id="loginForm2">
		<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
		<label class="" for="exampleInputPassword2">EMAIL</label>
		<input type="text" class="form-control" id="loginId" placeholder="Enter id" name="id">
		<label class="" for="exampleInputPassword2" style="margin-top:10px;">Password</label>
		<input type="password" class="form-control"	id="loginPWD" placeholder="Password" name="password">
		<button type="button" class="btn btn-default pull-right" style="margin-top:10px; color:white;" value="Login" onclick="ajaxLogin2()">로그인</button>
		<button type="button" class="btn btn-default pull-right" style="margin-top:10px; color:white;" value="Login" onclick="location.href='/join'">회원가입</button>
	</form> 
</div>
