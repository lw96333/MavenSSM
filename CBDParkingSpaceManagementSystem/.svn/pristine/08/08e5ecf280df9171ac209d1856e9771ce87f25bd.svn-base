$(function(){
	var url = window.location.href;//项目里面这里用window.location.href;
	var  arr = url.split("carid=");
	var info = arr[1].split("&");
	var buy =null;
	//alert("carid"+info[0]+"购买人id:"+info[1]);
	//获取合同信息，包涵双方信息
	var purChaserId = info[1];
	function Push(purChaserId){
		$.ajax({
			type : "post",
			url : "sellConsentContractPush",
			data : {
				"purChaserId" :purChaserId
			}
		});
	}
	 $.ajax({
	type:"post",
	url:"selectContract",
	data:{
		"carParkId":info[0]
	},
	dataType : 'json',
	success:function(data){
		//console.log(data);
		 buy = data.data.buy;
		var shell = data.data.shell;
		if(buy!=null){
			$("#gname").html(buy.name);
			$("#gzname").html(buy.realname);
			$("#gsfz").html(buy.identitynumber);
			$("#gphone").html(buy.phone);
			$("#hetong").html("CBDC-1300151"+buy.userid)
			purChaserId = buy.userid;
		}
		$("#cname").html(shell.name);
		$("#czname").html(shell.realname);
		$("#csfz").html(shell.identitynumber);
		$("#cphone").html(shell.phone);
		$("#caddress").html(shell.address);
		$("#cbianhao").html(shell.areaid);
		$("#pyjy").html(shell.price);
		
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
						"carParkId":info[0],
						"type":0,
						"number":$("#hetong").html()
					},
					dataType : 'json',
					success:function(data){
						 Push(purChaserId);
						 layer.msg('交易成功! ',{icon:1,time:1000})
							setTimeout(function(){
								window.parent.location.reload();
							},1500);
					}
				}); 
		}
	
	})
	$("#btnq").click(function(){
		$.ajax({
			type : "post",
			url : "CancellationOfContract",
			data : {
			"carId" :info[0]
			},
			dataType : 'json',
			success : function(data) {
				//推送消息
				 $.ajax({
						type : "post",
						url : "noConsentContractPush",
						data : {
						"userid" :purChaserId
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
