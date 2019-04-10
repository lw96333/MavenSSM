$(function(){
	C1 = window.location.href.split("?")[1]; // 得到id
	C2 = C1.split("=")[1]; // 得到值
	var dealInfo = "";
	var userid;
$("#Reserve").mousedown(function(){
		if(userid == $("#userId").val()) {
			layer.msg('这是你的车位哦!', {
				icon : 1,
				time : 1000
			});
		} else {
	
			layer.confirm('确定预约？', function(index) {
				$.ajax({
					type : "post",
					url : "insertDealLJQ",
					async : false,
					data : {
						"privatecarsid" : dealInfo.privatecarsid,
						"userid" : $("#userId").val(),
						"startime" : dealInfo.starttime,
						"endtime" : dealInfo.endtime,
						"message" : $("#beizu").val(),
						"state" : "已预定",
						"price" : dealInfo.price
					},
					dataType : 'json',
					success : function(data) {
						if (data.code == 200) {
							layer.msg('预约成功!', {
								icon : 1,
								time : 1000
							});
							$.ajax({
								type : "post",
								url : "leasePush",
								data : {
									"carid" : dealInfo.privatecarsid
								},
								dataType : 'json'
							});
							setInterval(function() {
						        window.parent.location.href='jsp/fortend/personal/CarRentalFrontPage.jsp';
						    }, 1000);
						} else {
							layer.msg('好像出了点错误呢!', {
								icon : 1,
								time : 1000
							});
						}
					}
				});
			});
		}
});
	
	$.ajax({
		type : "post",
		url : "getParkingByIdLJQ",
		async : false,
		data : {
			"id" : C2
		},
		dataType : 'json',
		success : function(data) {
			var info = data.data.parkingInfo;
			if (data.code == 200) {
				dealInfo = info;
				console.log(info);
				console.log(C2);
				$("#time").text(info.issuetime);
				$("#job").text(info.job);
				$("#name").text(info.name);
				$("#phone").text(info.phone);
				var y = "☆"; 
				var x = "★"; 
				var dealnumber = info.dealnumber;
				var complaintnumber = info.complaintnumber;
				var credit;
				if(dealnumber==0&&complaintnumber==0){
					credit = 91;
	    		}else{
	    			credit = (dealnumber/(dealnumber+complaintnumber))*100;
	    		}
				
				if(credit <= 10){
					$("#reputation").text(y+y+y+y+y);
				}
				if(credit > 10 && credit <= 20){
					$("#reputation").text(x+y+y+y+y);
				}
				if(credit > 20 && credit <= 40){
					$("#reputation").text(x+x+y+y+y);
				}
				if(credit > 40 && credit <= 60){
					$("#reputation").text(x+x+x+y+y);
				}
				if(credit > 60 && credit <= 80){
					$("#reputation").text(x+x+x+y+y);
				}
				if(credit > 80 && credit <= 90){
					$("#reputation").text(x+x+x+x+y);
				}
				if(credit > 90){
					$("#reputation").text(x+x+x+x+x);
				}
				
				userid = info.userid;
				/*console.log($("#userId").val());
				if(userid == $("#userId").val()) {
					layer.msg('这是你的车位哦!', {
						icon : 1,
						time : 1000
					});
					$("#Reserve").attr("disabled",true);
				} else {
					$("#Reserve").attr("disabled",false);
				}
				*/
			} else {
				layer.msg('好像出了点错误呢!', {
					icon : 1,
					time : 1000
				});
			}

		}
	});
	$("#cancel").mousedown(function() {
		  layer_close();
	});
    $('.skin-minimal input').iCheck({
        checkboxClass: 'icheckbox-blue',
        radioClass: 'iradio-blue',
        increaseArea: '20%'
    });

    $("#form-member-add").validate({
        rules:{
            username:{
                required:true,
                minlength:2,
                maxlength:16
            },
            sex:{
                required:true,
            },
            mobile:{
                required:true,
                isMobile:true,
            },
            email:{
                required:true,
                email:true,
            },
            uploadfile:{
                required:true,
            },

        },
        onkeyup:false,
        focusCleanup:true,
        success:"valid",
        submitHandler:function(form){
            //$(form).ajaxSubmit();
            var index = parent.layer.getFrameIndex(window.name);
            //parent.$('.btn-refresh').click();
            parent.layer.close(index);
        }
    });
});
