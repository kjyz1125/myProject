$(function(){
	
});

function ajaxJoin(){
	
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
		url: '/join.do',
		data: $("#joinForm").serialize(),
		dataType : 'json',
		async:false,
		success : function(data) {
			if(data.result == 1){
				alert("회원가입 성공");
				location.href="/";
			}else{
				alert("회원가입 실패");
			}
	    },error : function(data){
	    	alert("회원가입 실패");
	    }
	});
} 

