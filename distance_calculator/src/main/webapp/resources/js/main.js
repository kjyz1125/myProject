$(function(){
	
/*	$(document).on("click",".menu",function(e){ 
		e.preventDefault();
		
		var idx = $(this).attr("data");
		
		if(idx == 'django-api'){
			location.href = "http://localhost:8000/api/v1/members";
		}else if(idx == 'github'){
			window.open("https://github.com/kjyz1125","_blank");
		}else if(idx == 'jenkins'){
			window.open("http://52.79.79.61:8080","_blank");
		}else if(idx == 'login'){
			$("#loginPopup").show();
		}else{
			location.href="/"+idx;
		}
	});*/
	
	$(".login").keydown(function(e){ 
        if(e.keyCode == 13){
        	ajaxLogin2();
        }
    });
	
	$(".navbar-toggler").click(function(e){
		e.preventDefault();
		
		$(".navbar-collapse").addClass("show");
	});
});

function loginPopup(){
	$("#loginPopup").show();
}

function ajaxLogin2(){
	
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	$.ajaxSetup({
	     beforeSend: function(xhr) {
	        xhr.setRequestHeader('CORS', 'Access-Control-Allow-Origin');
	        xhr.setRequestHeader(header, token);
	    }
	});
	
	if($("#loginId").val() == ""){
		alert("아이디를 입력하세요.");
		return;
	}
	
	if($("#loginPWD").val() == ""){
		alert("비밀번호를 입력하세요.");
		return;
	}

	$.ajax({

		type: 'POST',
		url: '/login',
		data: $("#loginForm2").serialize(),
		dataType : 'json',
		async:false,
		success : function(data) {
			console.log("로그인 성공");
			location.href=data.returnUrl;
	    },error : function(data){
	    	alert("로그인실패");
	    }
	});
} 

function ajaxLogout(){
	
	
	var result = confirm("로그아웃 하시겠습니까?");
	
	if(result){
	
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		
		$.ajaxSetup({
		     beforeSend: function(xhr) {
		        xhr.setRequestHeader('CORS', 'Access-Control-Allow-Origin');
		        xhr.setRequestHeader(header, token);
		    }
		});
	
		$.ajax({
			type: 'POST',
			url: '/logout',
			async:false,
			success : function(data) {
				location.href="/";
		    },error : function(data){
		    	location.href="/";
		    }
		});
	}else{
		return;
	}
}


