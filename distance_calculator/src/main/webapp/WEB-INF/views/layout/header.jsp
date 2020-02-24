<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <meta name="google-site-verification" content="7-4X054VS5YBVdO0OcsJ1sKb1GlgScvozHTyFmmnY4Y" />
    <meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
	<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>
    
    <link rel="stylesheet" type="text/css" href="/resources/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/common.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
	<script type="text/javascript" src="/resources/js-lib/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="/resources/js/main.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script data-ad-client="ca-pub-2773802897897850" async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	    <div class="navbar-header">
	    	<a class="navbar-brand" href="/">eljamdev</a>
	    </div>
	    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarMenu">
	      <span class="navbar-toggler-icon"></span>
	    </button>
		<div class="navbar-collapse collapse" id="navbarMenu">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="/bbs">NOTICE</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/devOps">STUDY</a>
				</li>
				<c:choose>
				    <c:when test="${not empty name}">
				        <li class="nav-item">
				        	<div class="text-center">
				        		<a class="nav-link" href="#" onclick="ajaxLogout()">LOGOUT</a>
							</div>
						</li>
				    </c:when>
				    <c:otherwise>
						 <li class="nav-item">
				        	<div class="text-center">
							  <a class="nav-link" href="#" onclick="loginPopup()">LOGIN</a>
							</div>
						 </li>
				    </c:otherwise>                  
				</c:choose>
			</ul>
		</div>
	</nav>
</body>
<!-- 						 <div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
						    <form id="loginForm2">
							      <div class="modal-header text-center">
							        <h4 class="modal-title w-100 font-weight-bold">Sign in</h4>
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
							          <span aria-hidden="true">&times;</span>
							        </button>
							      </div>
							      <div class="modal-body mx-3">
							        <div class="md-form mb-5">
							          <i class="fas fa-envelope prefix grey-text"></i>
							          <input type="email" id="defaultForm-email" class="form-control validate">
							          <label data-error="wrong" data-success="right" id="loginId" for="defaultForm-email">Your ID</label>
							        </div>
							
							        <div class="md-form mb-4">
							          <i class="fas fa-lock prefix grey-text"></i>
							          <input type="password" id="defaultForm-pass" class="form-control validate">
							          <label data-error="wrong" data-success="right" id="loginPWD" for="defaultForm-pass">Your password</label>
							        </div>
							
							      </div>
							      <div class="modal-footer d-flex justify-content-center">
							        <button class="btn btn-default">Login</button>
							      </div>
						      </form>
					    </div>
					  </div>
					</div> -->
<div style="margin-bottom:5%;">
</div>
<div id="loginPopup" style="position:absolute;width:20%;top:11%;left:75%;z-index:999;display:none; margin:0 auto;">
	<form id="loginForm2" style="background-color:black;">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<label class="" for="exampleInputPassword2">EMAIL</label>
		<input type="text" class="form-control login" id="loginId" placeholder="Enter id" name="id">
		<label class="" for="exampleInputPassword2" style="margin-top:10px;">Password</label>
		<input type="password" class="form-control login"	id="loginPWD" placeholder="Password" name="password">
		<button type="button" class="btn btn-default pull-right" style="margin-top:10px; color:white;" value="Login" onclick="ajaxLogin2()">로그인</button>
		<button type="button" class="btn btn-default pull-right" style="margin-top:10px; color:white;" value="Join" onclick="location.href='/join'">회원가입</button>
	</form> 
</div>

