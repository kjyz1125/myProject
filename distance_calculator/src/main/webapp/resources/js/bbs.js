$(function() {
	$("#write").click(function(e){
		e.preventDefault();
		
		var result = confirm("Are you sure you want to save this?");
		
		if(result){
			
			var param = $("#writeForm").serialize();
			
			$.ajax({
				url: './write.do',
		        type: 'POST',
		        data: param,
		        success: function (result) {
		        	if(result == "SUCCESS"){
		            	alert("성공");
		            	window.location.href = "/bbs";
		            }else{
		            	alert("실패");
		            	window.location.href = "/bbs";
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
		
		var result = confirm("Are you sure you want to delete this?");
		
		if(result){
			
			var idx = { "idx" : $("#idx").attr("data")};
			
			$.ajax({
				url: './delete.do',
		        type: 'POST',
		        data: idx,
		        success: function (result) {
		            if(result == "SUCCESS"){
		            	alert("성공");
		            	window.location.href = "/bbs";
		            }else{
		            	alert("실");
		            	window.location.href = "/bbs";
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
		
		var result = confirm("Are you sure you want to update this?");
		
		if(result){
			
			var param = $("#writeForm").serialize();
			
			$.ajax({
				url: './update.do',
		        type: 'POST',
		        data: param,
		        success: function (result) {
		            if(result == "SUCCESS"){
		            	alert("성공");
		            	window.location.href = "/bbs";
		            }else{
		            	alert("실");
		            	window.location.href = "/bbs";
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
});

