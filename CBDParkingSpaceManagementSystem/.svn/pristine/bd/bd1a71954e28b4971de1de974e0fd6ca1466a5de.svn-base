$(function(){
var y = "☆"; 
var x = "★"; 
var url = window.location.href;//项目里面这里用window.location.href;
var  arr = url.split("info=");
var info = arr[1];
var infos = info.split("&");
console.log("购买人id:"+infos[5]+"车位id:"+infos[6]);
/* $("#stateTime").html(infos[0]);//开始时间*/
$("#userName").html(decodeURI(infos[0]));//名称
$("#job").html(decodeURI(infos[1]));//职业
$("#phone").html(infos[2]);//电话
var xingyudu = parseInt(infos[3]);
$("#xyd").html();//信誉度
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
$("#message").html(decodeURI(infos[4]));//留言 
$("#lease").click(function(){
	//改变出售车位的状态
 	$.ajax({
	type : "post",
	url : "insertShellPark",
	data : {
		"carParkId" :infos[6]
	},
	dataType : 'json',
	success : function(data) {
		//layer.msg('成功! ',{icon:1,time:1000})
		 $.ajax({
		type : "post",
		url : "agreedToSellPush",
		data : {
		"purChaserId" :infos[5]
		}
	}); 
		layer.msg('成功! ',{icon:1,time:1000})
		setTimeout(function(){
			window.parent.location.reload();
		},1500);
		
	} 
	}); 
	//window.parent.location.reload();
	//layer_close();
})
$("#noRent").click(function(){
	$.ajax({
		type : "post",
		url : "CancellationOfContract",
		data : {
		"carId" :infos[6]
		},
		dataType : 'json',
		success : function(data) {
			//推送消息
			 $.ajax({
					type : "post",
					url : "noAgreedPush",
					data : {
					"purChaserId" :infos[5]
					}
				}); 
			 layer.msg('成功! ',{icon:1,time:1000})
				setTimeout(function(){
					window.parent.location.reload();
				},1200);
			//layer_close();
		}
	}); 

})
})