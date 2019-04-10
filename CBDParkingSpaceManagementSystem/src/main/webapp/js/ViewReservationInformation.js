var userID = 0;
var startime = "";
var endtime = "";
var price = "";
$("#cancel").click(function(){
	layer_close();
});
$(function() {
	C1 = window.location.href.split("?")[1]; // 得到id
	C2 = C1.split("=")[1]; // 得到值
	$.ajax({
		type : "post",
		data : {
			"privatecarsid" : C2
		},
		url : "showLessorInfo",
		async : false,
		dataType : 'json',
		success : function(data) {
			var lessorInfo = data.data.lessorInfo;
			userID = lessorInfo.userid;
			startime = lessorInfo.startime;
			endtime = lessorInfo.endtime;
			price = lessorInfo.price;
			if (data.code == 200) {
				$("#stateTime").text(lessorInfo.startime);
				$("#endTime").text(lessorInfo.endtime);
				$("#job").text(lessorInfo.job);
				$("#userName").text(lessorInfo.name);
				$("#phone").text(lessorInfo.phone);
				$("#message").text(lessorInfo.message);
				var dealnumber = lessorInfo.dealnumber;
				var complaintnumber = lessorInfo.complaintnumber;
				var y = "☆"; 
				var x = "★"; 
				var credit;
				if(dealnumber==0 && complaintnumber==0){
					credit = 91;
				}else{
					credit = (dealnumber/(dealnumber+complaintnumber))*1000;
				}
				if(credit <= 10){
					$("#credit").html(y+y+y+y+y);
				}
				if(credit > 10 && credit <= 20){
					$("#credit").html(x+y+y+y+y);
				}
				if(credit > 20 &&credit <= 40){
					$("#credit").html(x+x+y+y+y);
				}
				if(credit > 40 && credit <= 60){
					$("#credit").html(x+x+x+y+y);
				}
				if(credit > 60 && credit <= 80){
					$("#credit").html(x+x+x+y+y);
				}
				if(credit > 80 && credit <= 90){
					$("#credit").html(x+x+x+x+y);
				}
				if(credit > 90){
					$("#credit").html(x+x+x+x+x);
				}
			}
		}
	});

	$('.skin-minimal input').iCheck({
		checkboxClass : 'icheckbox-blue',
		radioClass : 'iradio-blue',
		increaseArea : '20%'
	});

	$("#form-member-add").validate({
		rules : {
			username : {
				required : true,
				minlength : 2,
				maxlength : 16
			},
			sex : {
				required : true
			},
			mobile : {
				required : true,
				isMobile : true
			},
			email : {
				required : true,
				email : true
			},
			uploadfile : {
				required : true
			}

		},
		onkeyup : false,
		focusCleanup : true,
		success : "valid",
		submitHandler : function(form) {
			// $(form).ajaxSubmit();
			var index = parent.layer.getFrameIndex(window.name);
			// parent.$('.btn-refresh').click();
			parent.layer.close(index);
		}
	});
});

$("#lease").mousedown(function() {
	layer.confirm('确认要出租给对方吗？', function(index) {
		$.ajax({
			type : "post",
			url : "confirmRental",
			dataType : "json",
			data : {
				"userId" : userID,
				"duserId" : $("#userId").val(),
				"privatecarsid" : C2,
				"startime" : startime,
				"endtime" : endtime,
				"price" : price
			},
			success : function(data) {
				if (data.code == 200) {
					layer.msg('出租成功!', {
						icon : 1,
						time : 1000
					});
					$.ajax({
						type : "post",
						url : "rentPush",
						data : {
							"purChaserId" : userID
						},
						dataType : 'json'
					});
					 window.parent.location.href='jsp/fortend/personal/ParkingSpaceRental.jsp';
				} else {
					layer.msg('好像出了点问题!', {
						icon : 1,
						time : 1000
					});
				}
			}
		});
	});
});

$("#noRent").mousedown(function() {
	layer.confirm('确认取消出租给对方吗？', function(index) {
		$.ajax({
			type : "post",
			url : "cancellationOfRental",
			dataType : "json",
			data : {
				"userId" : userID,
				"privatecarsid" : C2
			},
			success : function(data) {
				if (data.code == 200) {
					layer.msg('取消出租成功!', {
						icon : 1,
						time : 1000
					});
					window.parent.location.href='jsp/fortend/personal/ParkingSpaceRental.jsp';
				} else {
					layer.msg('好像出了点问题!', {
						icon : 1,
						time : 1000
					});
				}
			}
		});
	});
});
