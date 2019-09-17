var map = null;

$(function() {
	$(document).on("click",".address",function(e){ 
		e.preventDefault();
		getAddress($(this));
	});
	
	$("#plus").on("click",function(e){
		e.preventDefault();
		var length = $("#addressBox").find(".address").length;
		if(length >= 6){
			alert("최대인원은 6명입니다.");
			return;
		}
		$("#addressBox").append('<p>주소 <input type="text" class="address" readonly="readonly" style="width:50%"></p>');
		
	});
	
	$("#minus").on("click",function(e){
		e.preventDefault();
		var length = $("#addressBox").find(".address").length-1;
		if(length < 2){
			alert("최소인원은 2명입니다.");
			return;
		}
		$("#addressBox").find(".address:eq("+length+")").parent().remove();
	});
});

function getAddress(obj){
	
	var input = obj;
	
	new daum.Postcode({
	    oncomplete: function(data) {
	    	input.val(data.address);
	    }
	}).open();
}

function getLocation() {
  if (navigator.geolocation) {
	  navigator.geolocation.getCurrentPosition(onSuccessGeolocation, onErrorGeolocation);
  } else { 
    alert("사용하는 브라우저는 해당 기능을 이용 할 수 없습니다. Chrome 사용을 추천드립니다.");
  }
}

function initMap(x,y) {
    map = new naver.maps.Map('map', {
        center: new naver.maps.LatLng(x,y),
        zoom: 5
    });
}

function onSuccessGeolocation(position) {
    
	var infowindow = new naver.maps.InfoWindow();
	var location = new naver.maps.LatLng(position.coords.latitude, position.coords.longitude);
    
    initMap(position.coords.latitude,position.coords.longitude);

    map.setCenter(location); // 얻은 좌표를 지도의 중심으로 설정합니다.
    map.setZoom(10); // 지도의 줌 레벨을 변경합니다.

    infowindow.setContent('<div style="padding:20px;">' + '내 위치' + '</div>');

    infowindow.open(map, location);
    console.log('Coordinates: ' + location.toString());
}

function onErrorGeolocation() {
    var center = map.getCenter();

    infowindow.setContent('<div style="padding:20px;">' +
        '<h5 style="margin-bottom:5px;color:#f00;">Geolocation failed!</h5>'+ "latitude: "+ center.lat() +"<br />longitude: "+ center.lng() +'</div>');

    infowindow.open(map, center);
}