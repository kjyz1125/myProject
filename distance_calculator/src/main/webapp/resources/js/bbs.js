$(function() {
	
	$("#write").click(function(e){
		e.preventDefault();
		
		var result = confirm("글을 저장하시겠습니까?");
		
		if(result){
			
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			
			$.ajaxSetup({
			     beforeSend: function(xhr) {
			        xhr.setRequestHeader('CORS', 'Access-Control-Allow-Origin');
			        xhr.setRequestHeader(header, token);
			    }
			});
			
			
			var param = $("#writeForm").serialize();
			
			$.ajax({
				url: './write.do',
		        type: 'POST',
		        data: param,
		        success: function (result) {
		        	if(result == "SUCCESS"){
		            	window.location.href = "/"+location.pathname.split("/")[1];
		            }else{
		            	alert("실패");
		            	window.location.href = "/"+location.pathname.split("/")[1];
		            }
		        },
		        error: function(XMLHttpResponse){
		        	alert('ERROR');
		        }
			});
		}else{
			return;
		}
	});
	
	$("#delete").click(function(e){
		e.preventDefault();
		
		var result = confirm("글을 삭제하시겠습니까?");
		
		if(result){
			
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			
			$.ajaxSetup({
			     beforeSend: function(xhr) {
			        xhr.setRequestHeader('CORS', 'Access-Control-Allow-Origin');
			        xhr.setRequestHeader(header, token);
			    }
			});
			
			var idx = { "idx" : $("#idx").attr("data")};
			
			$.ajax({
				url: './delete.do',
		        type: 'POST',
		        data: idx,
		        success: function (result) {
		            if(result == "SUCCESS"){
		            	window.location.href = "/"+location.pathname.split("/")[1]
		            }else{
		            	alert("실");
		            	window.location.href = "/"+location.pathname.split("/")[1]
		            }
		            
		        },
		        error: function(XMLHttpResponse){
		        	alert('ERROR');
		        }
			});
		}else{
			return;
		}
	});
	
	$("#update").click(function(e){
		e.preventDefault();
		
		var result = confirm("글을 수정하시겠습니까?");
		
		if(result){
			
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			
			$.ajaxSetup({
			     beforeSend: function(xhr) {
			        xhr.setRequestHeader('CORS', 'Access-Control-Allow-Origin');
			        xhr.setRequestHeader(header, token);
			    }
			});
			
			var param = $("#writeForm").serialize();
			
			$.ajax({
				url: './update.do',
		        type: 'POST',
		        data: param,
		        success: function (result) {
		            if(result == "SUCCESS"){
		            	window.location.href = "../"+$("input[name=idx]").val();
		            }else{
		            	alert("실패");
		            	window.location.href = location.pathname;
		            }
		            
		        },
		        error: function(XMLHttpResponse){
		        	alert('ERROR');
		        }
			});
		}else{
			return;
		}
	});
	
	$("#search").click(function(e){
		e.preventDefault();
		
		var param = location.pathname;
		param += "?keyword=" + $("#keyword").val();
		param += "&searchType=" + $('#searchType').val();

		location.href = param;
	});
});

function fn_prev(page, range, rangeSize) {

	var page = ((range - 2) * rangeSize) + 1;
	var range = range - 1;	
	var url = location.pathname;

	url = url + "?page=" + page;
	url = url + "&range=" + range;

	location.href = url;
}

function fn_pagination(page, range, rangeSize, searchType, keyword) {
	
	var url = location.pathname;
	
	url = url + "?page=" + page;
	url = url + "&range=" + range;

	location.href = url;	
}

function fn_next(page, range, rangeSize) {
	
	var page = parseInt((range * rangeSize)) + 1;
	var range = parseInt(range) + 1;
	var url = location.pathname;

	url = url + "?page=" + page;
	url = url + "&range=" + range;

	location.href = url;
}
