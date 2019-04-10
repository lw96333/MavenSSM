$(function() {
		
		<!-- 自带 -->
		$('.skin-minimal input').iCheck({
			
			checkboxClass : 'icheckbox-blue',
			radioClass : 'iradio-blue',
			increaseArea : '20%'
		});
		
		$("#form-member-add").validate({
			
			rules : {
				jobID : {
					required : true,
					minlength : 2,
					maxlength : 16
				},
				password : {
					required : true
				},
				username : {
					required : true
				},
				phone : {
					required : true,
					isMobile : "请正确填写手机号码"

				}
			},
			onkeyup : false,
			focusCleanup : true,
			success : "valid",
			submitHandler : function(form) {	
				add();
			}
		});
	});

	
	function add(){
		
		var arr = new Array();
		var num = 0;
		
		var phone = $("#phone").val();
	
		
	    $("input:checkbox").each(function(i){
			
	     	if ($(this).prop('checked')) { 
		        arr.push($(this).val()); 
		        num++;
		    } 
	    });

		if(num==0){
			layer.msg('请选择权限！',{icon:1,time:1000});
			return;
		}

	    var vals = arr.join(",");

	    $.ajax({
			type:"post",
			url:"super/insertAdmin",
			data:{
				"name":$("#username").val(),
				"password":$("#password").val(),
				"jobnumber":$("#jobID").val(),
				"phone":phone,
				"jurisdiction":vals
			},
			dataType:"json",
			success:function(data){
				if(data.code==200){
					layer.msg('添加成功！',{icon:1,time:1000});
					setTimeout(function () { 
						window.location.href="jsp/backstage/spuer/ShowAdmin.jsp"; 
						}, 1500); 
					
				}else if(data.code==5){
					layer.msg('工号已经存在！',{icon:1,time:1000});

				}
			}
		});
	}
	

	//手机号码验证  

	jQuery.validator.addMethod("isMobile", function(value, element) {  

	 var length = value.length;  

	 var mobile = /^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$/;  

	 return this.optional(element) || (length == 11 && mobile.test(value));  

	}, "请正确填写手机号码");  
