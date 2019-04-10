$(function(){
	var y = "☆"; 
	var x = "★"; 
	var url = window.location.href;//项目里面这里用window.location.href;
	var  arr = url.split("info=");
	var info = arr[1];
	var infos = info.split("&");
	console.log(decodeURI(infos));
	$("#stateTime").html(infos[0]);//开始时间
	$("#userName").html(decodeURI(infos[1]));//名称
	$("#job").html(decodeURI(infos[2]));//职业
	$("#phone").html(infos[3]);//电话
	$("#pice").html(infos[5]);//价格
	var xingyudu = parseInt(decodeURI(infos[4]));
	console.log(xingyudu);
	//$("#xyd").html();信誉度
	if(xingyudu<=10){
		$("#xyd").html(y+y+y+y+y);
	}
	if(xingyudu>10&&xingyudu<=20){
		$("#xyd").html(x+y+y+y+y);
	}
	if(xingyudu>20&&xingyudu<=40){
		$("#xyd").html(x+x+y+y+y);
	}
	if(xingyudu>40&&xingyudu<=60){
		$("#xyd").html(x+x+x+y+y);
	}
	if(xingyudu>60&&xingyudu<=80){
		$("#xyd").html(x+x+x+y+y);
	}
	if(xingyudu>80&&xingyudu<=90){
		$("#xyd").html(x+x+x+x+y);
	}
	if(xingyudu>90){
		$("#xyd").html(x+x+x+x+x);
	}
	$("#message").val("我要订你的车位");//留言

	function Push(){
		$.ajax({
			type : "post",
			url : "pookingPush",
			data : {
				"carid" :infos[7]
			}
		});
	}
	$("#lease").click(function(){
		//改变出售车位的状态
		var userid = infos[6];
		//alert(userid)
		var shellid = $("#id").html();
		if(shellid==userid){
			layer.msg('自己不能订购自己的车位',{icon:1,time:1000});
		}else{
			$.ajax({
				type : "post",
				url : "insertBuyCar",
				data : {
					"price" :infos[5],
					"carParkId" :infos[7],
					"message":$("#message").val()
				},
				dataType : 'json',
				success : function(data) {
					Push();
					layer.msg('订购成功! ',{icon:1,time:1000});
					setTimeout(function(){
						window.parent.location.reload();
					},1500);
				} 
			}); 
		}

	})
	$("#noRent").click(function(){
		layer_close();
	})
	
})
