$(function() {
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
	
	function ajaxLogin2(){
		
		$.ajax({

			type: 'POST',
			url: '/login.do',
			data: $("#loginForm2").serialize(),
			dataType : 'json', 
		    success : function(data) {
		    	location.href="/main";
		    },error : function(data){
		    	alert("로그인실패");
		    }
		});
	} 
});