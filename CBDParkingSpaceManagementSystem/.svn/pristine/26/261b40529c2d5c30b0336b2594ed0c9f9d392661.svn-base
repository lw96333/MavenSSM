
//个人用户修改
$(function() {
	window.onload = function()
	{
		$.ajax({
			type:"post",
			url : "selectPersonage",
			dataType : "json",
			success : function(data) {
				$("#adderss").val(data.data.us.address);
				$("#phone").val(data.data.us.phone);
				$("#job").val(data.data.us.job);
				$("#email").val(data.data.us.email);
			}
		});
	}
	
	$("#password").blur(function(){
		checkNull($(this),"请输入2~12位英文字母和数字","请输入2~12位英文字母和数字");
	});
	$("#passwords").blur(function(){
		checkNull($(this),"请输入2~12位英文字母和数字","请输入2~12位英文字母和数字");
	});
	$("#address").blur(function(){
		checkNull($(this),"请输入2~15位字符","请输入2~15位字符");
	});
	$("#phone").blur(function(){
		checkNull($(this),"请输入11位手机号码","请输入11位手机号码");
	});
	$("#job").blur(function(){
		checkNull($(this),"请输入个人职业","请输入个人职业");
	});
	$("#email").blur(function(){
		checkNull($(this),"请输入个人QQ邮箱","请输入个人QQ邮箱");
	});
	
	$("#btn_alter").click(function() {
		
		var password = $("#password").val().trim();
		var passwords = $("#passwords").val().trim();
		var adderss = $("#adderss").val().trim();
		var phone = $("#phone").val().trim();
		var job = $("#job").val().trim();
		var email = $("#email").val().trim();
		
		var falg = true;
		falg = checkNull($("#password"),"请输入2~12位英文字母和数字","请输入2~12位英文字母和数字");
		falg = checkNull($("#passwords"),"请输入2~12位英文字母和数字","请输入2~12位英文字母和数字");
		falg = checkNull($("#address"),"请输入2~15位字符","请输入2~15位字符");
		falg = checkNull($("#phone"),"请输入11位手机号码","请输入11位手机号码");
		falg = checkNull($("#job"),"请输入个人职业","请输入个人职业");
		falg = checkNull($("#email"),"请输入个人QQ邮箱","请输入个人QQ邮箱");
		
		if(falg){
			//密码只能为英文和数字
    		var reg2 = /[a-zA-Z0-9]/g;
			//11为电话号码正则表达式
		    var arg1 = /^1(3|4|5|7|8)\d{9}$/;
		    //邮箱
		    var arg2 = /^\w{5,}@[a-z0-9]{2,3}\.[a-z]+$|\,$/;
			
			if (password.match(reg2) == null) {
				layer.msg('密码输入格式有误，请从新输入',{icon:1,time:1500});
			}else if(passwords.match(reg2) == null){
				layer.msg('再次输入新密码格式有误，请从新输入',{icon:1,time:1500});
//			}else if(adderss == ""){
//				layer.msg('地址输入不能为空，请从新输入',{icon:1,time:1500});
			}else if(phone.match(arg1) == null){
				layer.msg('电话号码输入格式有误，请从新输入',{icon:1,time:1500});
//			}else if(job == ""){
//				layer.msg('职业不能为空，请从新输入',{icon:1,time:1500});
			}else if(email.match(arg2) == null){
				layer.msg('邮箱格式输入有误，请从新输入',{icon:1,time:1500});
			}else if(password != passwords){
				layer.msg('两次输入密码不匹配，请从新输入',{icon:1,time:1500});
			}else{
				$.ajax({
					type : "post",
					url : "updataPersonage",
					data : {
						"password" : password,
						"adderss" : adderss,
						"phone" : phone,
						"job" : job,
						"email" : email
					},
					dataType : "json",
					success : function(data) {
						layer.msg('修改成功',{icon:1,time:1500});
						setTimeout(function () { 
							parent.location.href="jsp/FortendLogin.jsp";
						}, 1500); 
					}
				});
			}
		}
	});
});
function checkNull(obj,errorMessage,messgae){
	var falg = true;
	if(obj.val()==""){
		obj.css("border","1px red solid");
		obj.attr("placeholder",errorMessage);
		falg = false;
	}else{
		obj.css("border","1px #DCDCDC solid");
		obj.attr("placeholder",messgae);
	}
	return falg;
}

