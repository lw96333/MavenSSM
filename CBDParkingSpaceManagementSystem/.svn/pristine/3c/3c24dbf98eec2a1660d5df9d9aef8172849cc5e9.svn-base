$(function(){
		$.ajax({
			type:"post",
			url:"login",
			dataType:"json",
        	success:function(data){
        		console.log(data);
        		if(data.data.anyOne != []){
        			$(location).attr("href","jsp/fortend/index-user.jsp");
        		}
        	}
		});
		
		$("input[name=userName]").blur(function(){

			if($(this).val() == ""){
				$("input[name=userName]").css("border","1px red solid");
				$("input[name=userName]").attr("placeholder","账号不能为空！");
			}else{
				$("input[name=userName]").css("border","1px #DCDCDC solid");
				$("input[name=userName]").attr("placeholder","账号");
			}
		});
		
		$("input[name=password]").blur(function(){

			if($(this).val() == ""){
				$("input[name=password]").css("border","1px red solid");
				$("input[name=password]").attr("placeholder","密码不能为空！");
			}else{
				$("input[name=password]").css("border","1px #DCDCDC solid");
				$("input[name=password]").attr("placeholder","密码");
			}
		});
		
		$("input[name=backLogin]").click(function(){
			
			$(location).attr("href","jsp/SelectLogin.jsp");
		});
		 $("#type").on("change",function(){

			 if($(this).val()==0){
				 
				 $("#res").css('display','block'); 
			 }else if($(this).val()==1){
				 $("#res").css('display','none'); 
			 }
		 });
		$("input[name=login]").click(function(){
			var userName = $("input[name=userName]").val();
			var password = $("input[name=password]").val();

			var falg = $("#online").prop("checked");
			
			var type = $("#type").val();
			
			var falg = true;
			if(userName == ""){
				$("input[name=userName]").blur();
				falg = false;
			}
			if(password == ""){
				$("input[name=password]").blur();
				falg = false;
			}
			
			if(falg){
				$.ajax({
					type:"post",
					url:"fortendLogin",
					data:{
						"userName":userName,
						"password":password,
						"type":type,
						"remeberMe":falg
					},
					dataType:"json",
					success:function(data){
						console.log(data);
						if(data.code==200){
							$(location).attr("href","jsp/fortend/index-user.jsp");
						}else if(data.code == 5){
							layer.msg('账号密码不匹配!',{icon:1,time:1000});
						}else if(data.code == 3){
							layer.msg('账号不存在!',{icon:1,time:1000});
						}
						
					}
				});
			}
			
			
		});
	});