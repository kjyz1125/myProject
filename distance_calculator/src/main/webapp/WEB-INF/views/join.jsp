<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="/resources/css/reset.css">
    <script type="text/javascript" src="/resources/js/join.js"></script>
    <title>JOIN - eljamdev</title>
</head>
<body style="width:100%; height:100%;">


	<div id="join" class="form" style="width:50%; margin:0 auto;">
	
	회원 가입
	<form id="joinForm">
		<label class="mt10" for="exampleInputPassword2">ID (공백없이 4~11자리 '_' 이외 특수문자 불가)</label>
		<input type="text" class="mt10 form-control" id="joinId" placeholder="Enter id" name="id" required>
		<label class="mt10" for="exampleInputPassword2">Password (공백없이 8~20자리 영문,숫자,특수문자포함 필수)</label>
		<input type="password" class="mt10 form-control" id="joinPWD" placeholder="Enter Password" name="password" required>
		<label class="mt10" for="exampleInputPassword2">NAME</label>
		<input type="text" class="mt10 form-control" id="joinName" placeholder="Enter name" name="name" required>
		<label class="mt10" for="exampleInputPassword2" style="margin-top:10px;">EMAIL</label>
		<input type="text" class="mt10 form-control"	id="joinEmail" placeholder="Enter email" name="email">
		<button type="button" class="btn btn-primary" style="margin-top:10px;" value="join" onclick="ajaxJoin()">회원가입</button>
	</form> 
</div>
</body>
</html>
