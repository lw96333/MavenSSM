//个人注册
$(function() {
	$("#name").blur(function(){
		checkNull($(this),"请输入2~8位英文和数字","请输入2~8位英文和数字");
	});
	$("#password").blur(function(){
		checkNull($(this),"请输入2~12位英文字母和数字","请输入2~12位英文字母和数字");
	});
	$("#realname").blur(function(){
		checkNull($(this),"请输入2~5位字符","请输入2~5位字符");
	});
	$("#address").blur(function(){
		checkNull($(this),"请输入2~15位字符","请输入2~15位字符");
	});
	$("#phone").blur(function(){
		checkNull($(this),"请输入11位手机号码","请输入11位手机号码");
	});
	$("#identitynumber").blur(function(){
		checkNull($(this),"请输入18位身份证号码","请输入18位身份证号码");
	});
	$("#job").blur(function(){
		checkNull($(this),"请输入个人职业","请输入个人职业");
	});
	$("#email").blur(function(){
		checkNull($(this),"请输入个人QQ邮箱","请输入个人QQ邮箱");
	});
	$("#btn_enroll").click(
			function() {
				var name = $("#name").val();
				var password = $("#password").val();
				var realname = $("#realname").val();
				var address = $("#address").val();
				var phone = $("#phone").val();
				var identitynumber = $("#identitynumber").val();
				var job = $("#job").val();
				var email = $("#email").val();
				var falg = true;
				falg = checkNull($("#name"),"请输入2~8位英文和数字","请输入2~8位英文和数字");
				falg = checkNull($("#password"),"请输入2~12位英文字母和数字","请输入2~12位英文字母和数字");
				falg = checkNull($("#realname"),"请输入2~5位字符","请输入2~5位字符");
				falg = checkNull($("#address"),"请输入2~15位字符","请输入2~15位字符");
				falg = checkNull($("#phone"),"请输入11位手机号码","请输入11位手机号码");
				falg = checkNull($("#identitynumber"),"请输入18位身份证号码","请输入18位身份证号码");
				falg = checkNull($("#job"),"请输入个人职业","请输入个人职业");
				falg = checkNull($("#email"),"请输入个人QQ邮箱","请输入个人QQ邮箱");
				if(falg){
					//工号只能输入字母数字
					var reg = /^[0-9a-zA-Z]+$/;
					
					//11为电话号码正则表达式
				    var arg1 = /^1(3|4|5|7|8|9)\d{9}$/;
					//18位数身份证正则表达式
				    var arg2 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[A-Z])$/;
				    //邮箱
				    var arg3 = /^\w{5,}@[a-z0-9]{2,3}\.[a-z]+$|\,$/;
				    
					if (phone.match(reg) == null) {
						layer.msg('工号输入格式有误',{icon:1,time:1500});
					}else if(password.match(reg) == null){
						layer.msg('密码输入格式有误，请从新输入',{icon:1,time:1500});
//					}else if(realname == ""){
//						layer.msg('真实姓名输入不能为空，请从新输入',{icon:1,time:1500});
//					}else if(address == ""){
//						layer.msg('地址输入不能为空，请从新输入',{icon:1,time:1500});
					}else if(phone.match(arg1) == null){
						layer.msg('电话号码输入格式有误，请从新输入',{icon:1,time:1500});
					}else if(identitynumber.match(arg2) == null){
						layer.msg('身份证号码输入格式有误，请从新输入',{icon:1,time:1500});
//					}else if(job == ""){
//						layer.msg('职业输入不能为空，请从新输入',{icon:1,time:1500});
					}else if(email.match(arg3) == null){
						layer.msg('邮箱输入格式有误，请从新输入',{icon:1,time:1500});
					}else {
						$.ajax({
							type : "post",
							url : "insertPersonage",
							data : {
								"name" : name,
								"password" : password,
								"realname" : realname,
								"address" : address,
								"phone" : phone,
								"identitynumber" : identitynumber,
								"job" : job,
								"email" : email
							},
							dataType : "json",
							success : function(data) {
								console.log(data);
								var users = data.data.user2;
								console.log(users);
								if (users != null) {
									layer.msg('工号已存在，请从新输入',{icon:1,time:2000});
								} else {
									layer.msg('注册成功，请登录',{icon:1,time:2000})
									/* 返回个人登陆 */
									//self.location ="jsp/FortendLogin.jsp";
									setTimeout(function () { 
										window.location.href="jsp/FortendLogin.jsp"; 
										}, 1500); 
								}
							}
						});
					}
				}
			})
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