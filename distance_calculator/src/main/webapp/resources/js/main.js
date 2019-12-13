$(function(){
	
	$(document).on("click",".menu",function(e){ 
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
	});
});

function ajaxLogin2(){
	
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
	    	alert("로그아웃 성공");
	    },error : function(data){
	    	alert("로그아웃 실패");
	    }
	});
}


