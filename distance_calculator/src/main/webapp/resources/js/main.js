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
		}else{
			location.href="/"+idx;
		}
		
	});
});