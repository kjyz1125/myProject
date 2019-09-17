$(function() {
	$(document).on("click",".menu",function(e){ 
		e.preventDefault();
		
		var idx = $(this).attr("data");
		
		if(idx == 'django-api'){
			location.href = "http://localhost:8000/api/v1/members";
		}else if(idx == 'github'){
			location.href = "https://github.com/kjyz1125";
		}else{
			location.href="/"+idx;
		}
		
	});
});