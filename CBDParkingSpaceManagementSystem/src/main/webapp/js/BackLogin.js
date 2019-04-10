$(function(){
		$.ajax({
			type:"post",
			url:"login",
			dataType:"json",
        	success:function(data){
        		console.log(data);
        		if(data.data.admin != []){
        			$(location).attr("href","jsp/backstage/admin-index.jsp");
        		}
        	}
		});
		$("input[name=backLogin]").click(function(){
			
			$(location).attr("href","jsp/SelectLogin.jsp");
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
		
		$("input[name=login]").click(function(){
			
			var userName = $("input[name=userName]").val();
			var password = $("input[name=password]").val();
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
					url:"backLogin",
					data:{
						"jobnumber":userName,
						"password":password,
						"remeberMe":$("input[type=checkbox]").prop("checked")
					},
					dataType:"json",
					success:function(data){

						if(data.code==200){
							$(location).attr("href","jsp/backstage/admin-index.jsp");
						}else if(data.code == 5){
							layer.msg('账号密码不匹配!',{icon:1,time:1000});
						}else if(data.code == 3){
							layer.msg('账号不存在!',{icon:1,time:1000});
						}else if(data.code == 6){
							layer.msg('账号已经登录!',{icon:1,time:1000});
						}

					}
				});
			}
			
		});
	});