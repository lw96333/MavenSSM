$(function() {
	
		$('.skin-minimal input').iCheck({
			checkboxClass : 'icheckbox-blue',
			radioClass : 'iradio-blue',
			increaseArea : '20%'
		});

		$("#form-member-add").validate({
			rules : {
				password : {
					required : true,
				},
				passwords : {
					required : true,
					
				},
				phone : {
					required : true,
					
				},
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
	
	$(function(){
		
		window.onload = function()
		{
			$.ajax({
				type:"post",
				url : "selectAdmins",
				dataType : "json",
				success : function(data) {
					 $("#phone").val(data.data.us.phone);
				}
			});
		}
		
		$("#updata_admin").click(function(){
			var password = $("#password").val().trim();
			var passwords = $("#passwords").val().trim();
			var phone = $("#phone").val().trim();
			if(password == ""){
				layer.msg('新密码不能为空，请从新输入',{icon:1,time:1500});
			}else if(passwords == ""){
				layer.msg('再次输入新密码不能为空，请从新输入',{icon:1,time:1500});
			}else if(password != passwords){
				layer.msg('两次输入密码内容不同，请从新输入',{icon:1,time:1500});
			}else if(phone == ""){
				layer.msg('两次输入密码内容不同，请从新输入',{icon:1,time:1500});
			}else{
				$.ajax({
					type : "post",
					url : "adminUpdata",
					data:{
						"password" :password,
						"phone" : phone
					},
					dataType : "json",
					success : function(){
						layer.msg('修改成功',{icon:1,time:1500});
						setTimeout(function () { 
							parent.location.href="jsp/BackLogin.jsp";
							}, 1500);
					}
				});
			}
		});
	});