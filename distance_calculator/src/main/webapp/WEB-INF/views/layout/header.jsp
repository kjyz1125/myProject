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
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap/bootstrap.min.css">
	
	<script type="text/javascript" src="/resources/js-lib/jquery-3.3.1.js"></script>
	<script type="text/javascript" src="/resources/js-lib/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="/resources/js/main.js"></script>
	<script data-ad-client="ca-pub-2773802897897850" async src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark ">
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
							  <a href="" class="nav-link" data-toggle="modal" data-target="#modalLoginForm">LOGIN</a>
							</div>
						 </li>
				    </c:otherwise>                  
				</c:choose>
			</ul>
		</div>
	</nav>
</body>
<div style="margin-bottom:5%;">
</div>
<div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">LOGIN</h4>
      </div>
      <form id="loginForm2">
	      <div class="modal-body mx-3">
	        <div class="md-form mb-5">
	          <i class="fas fa-envelope prefix grey-text"></i>
	          <input type="text" id="loginId" placeholder="Enter id" name="id" class="login form-control validate">
	        </div>
	        <div class="md-form mb-4">
	          <i class="fas fa-lock prefix grey-text"></i>
	          <input type="password" id="defaultForm-pass"  id="loginPWD" placeholder="Password" name="password" class="login form-control validate">
	        </div>
	      </div>
	      <div class="modal-footer d-flex justify-content-center">
	        <a class="btn btn-default" href="#" onclick="ajaxLogin()">Sign in</a>
	        <a class="btn btn-default main" href="/join">Sign up</a>
	      </div>
      </form>
    </div>
  </div>
</div>
