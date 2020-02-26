$(function(){
	
});

function chkPwd(str){

    var pw = str;
    var num = pw.search(/[0-9]/g);
    var eng = pw.search(/[a-z]/ig);
    var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);


    if(pw.length < 8 || pw.length > 20){

     alert("8자리 ~ 20자리 이내로 입력해주세요.");

     return false;
    }

    if(pw.search(/₩s/) != -1){

     alert("비밀번호는 공백업이 입력해주세요.");

     return false;

    }if(num < 0 || eng < 0 || spe < 0 ){

     alert("영문,숫자, 특수문자를 혼합하여 입력해주세요.");

     return false;
    }

    return true;
 }

function ajaxJoin(){
	
	
	var result = chkPwd($("#joinForm").find("#joinPWD").val());
	
	if(!result){
		return;
	}
	
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
		success : function(data) {
			if(data == "SUCCESS"){
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

