<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="/resources/css/reset.css">
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>dc - eljamdev</title>
</head>
<body>
<script type="text/javascript" src="/resources/js-lib/jquery-3.3.1.js"></script>
<script type="text/javascript" src="/resources/js/dc.js"></script>
<script type="text/javascript" src="//ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="//openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=d9cvtp4p6u&callback=getLocation"></script>
<div style="width:100%; height:100%;">
	<p style="text-align:center;margin:10px;"> The time on the server is ${serverTime}.</p>
	</br>
	<div style="text-align:center; margin:0 auto; width:80%; height:6%;">
		<span id="plus" style="text-align:center; border:1px solid black; width:5%; height:5%;">+</span>
		<span id="minus" style="text-align:center; border:1px solid black; width:5%; height:5%;"> - </span>
	</div>
	</br>
	<div id="addressBox" style="text-align:center; width:100%">
		<p>주소 <input type="text" class="address" readonly="readonly" style="width:50%"></p>
		<p>주소 <input type="text" class="address" readonly="readonly" style="width:50%"></p>
	</div>
	</br>
	<div id="map" style="margin:0 auto; border:1px solid black; width:80%; height:80%;">

	</div>
</div>
</br>
</body>
</html>
