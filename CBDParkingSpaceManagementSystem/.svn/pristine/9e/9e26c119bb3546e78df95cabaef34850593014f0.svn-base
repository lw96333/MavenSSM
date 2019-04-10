
$(function(){
	var url = window.location.href;//项目里面这里用window.location.href;
	var  arr = url.split("carid=");
	var id = arr[1];
	var buy = null;
	//alert(id+"购买 ");
	//获取合同信息，包涵双方信息

	var sellerId = "";
	function Push(sellerId){
		$.ajax({
			type : "post",
			url : "buyConsentContractPush",
			data : {
				"sellerId" :sellerId
			}
		});
	}
$.ajax({
	type:"post",
	url:"selectContract",
	data:{
	"carParkId":id
	},
	dataType : 'json',
	success:function(data){
	console.log(data);
		buy = data.data.buy;
	var shell = data.data.shell;
	$("#cname").html(shell.name);
	$("#czname").html(shell.realname);
	$("#csfz").html(shell.identitynumber);
	$("#cphone").html(shell.phone);
	if(buy!=null){
		$("#hetong").html("CBDC-1300151"+buy.userid);
		$("#gname").html(buy.name);
		$("#gzname").html(buy.realname);
		$("#gsfz").html(buy.identitynumber);
		$("#gphone").html(buy.phone);
	}
	$("#caddress").html(shell.address);
	$("#cbianhao").html(shell.areaid);
	$("#pyjy").html(shell.price);
	
	sellerId = shell.userid;
}	
}); 
	$("#btnt").click(function(){
		if(buy==null){
			layer.msg('对方已不同意该合同交易终止! ',{icon:1,time:1000})
			setTimeout(function(){
				window.parent.location.reload();
			},1500);
		}else{
			$.ajax({
				type:"post",
				url:"insertContractNumber",
				data:{
					"carParkId":id,
					"type":1,
					"number":$("#hetong").html()
					
				},
				dataType : 'json',
				success:function(data){
					//page(currPage,pageSize);
					Push(sellerId);
					layer.msg('交易成功! ',{icon:1,time:1000})
					setTimeout(function(){
						window.parent.location.reload();
					},1500);
				
				}
			});
		}
		  
		//成功后跳转页面
		
		//layer_close();
	})
	$("#btnq").click(function(){
		$.ajax({
			type : "post",
			url : "CancellationOfContract",
			data : {
			"carId" :id
			},
			dataType : 'json',
			success : function(data) {
				//推送消息
				 $.ajax({
						type : "post",
						url : "noConsentContractPush",
						data : {
						"userid" :sellerId
						}
					}); 
				 layer.msg('成功! ',{icon:1,time:1000})
					setTimeout(function(){
						window.parent.location.reload();
					},1200);
				//layer_close();
			}
		});
		
		//layer_close();
	})	
	
	
	
	
})