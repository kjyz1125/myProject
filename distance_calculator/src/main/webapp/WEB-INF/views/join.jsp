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
	<div id="join" style="background-color:black;z-index:9999; width:50%;  margin:0 auto;">
	<form id="joinForm">
		<label class="" for="exampleInputPassword2">ID</label>
		<input type="text" class="form-control" id="joinId" placeholder="Enter id" name="id">
		<label class="" for="exampleInputPassword2" style="margin-top:10px;">Password</label>
		<input type="password" class="form-control"	id="joinPWD" placeholder="Enter Password" name="password">
		<label class="" for="exampleInputPassword2">NAME</label>
		<input type="text" class="form-control" id="joinName" placeholder="Enter name" name="name">
		<label class="" for="exampleInputPassword2" style="margin-top:10px;">PHONE</label>
		<input type="text" class="form-control"	id="joinPhone" placeholder="Enter phone number" name="phone">
		<label class="" for="exampleInputPassword2" style="margin-top:10px;">EMAIL</label>
		<input type="text" class="form-control"	id="joinEmail" placeholder="Enter email" name="email">
		<button type="button" class="btn btn-default pull-right" style="margin-top:10px; color:white;" value="join" onclick="ajaxJoin()">회원가입</button>
	</form> 
</div>
</body>
</html>
