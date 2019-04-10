
function judge(obj,str){
	var my = obj;
	if(my.val() != "" && my.val() != null){
		my.css({
			"border": "1px solid gainsboro"
		});
		return true;
	}else{
		my.attr("placeholder",str);
		my.css({
			"border": "1px solid red"
		});
		return false;
	}
}
$(function(){
	$("input[name=username]").on("blur",function(){
		judge($(this),"请输入出账号");
		
	});
	$("input[name=password]").on("blur",function(){
		judge($(this),"请输入密码");
	});
	$("input[name=login]").click(function(){
		var falg = true;
		var password = $("input[name=password]");
		var username = $("input[name=username]");
		if(username.val()==null || username.val() == ""){
			$("input[name=username]").blur();
			falg =false;
		}
		if(password.val()==null || password.val() == ""){
			$("input[name=password]").blur();
			falg =false;
		}
		if(falg){
			return true;
		}else{
			return false;
		}
	});
})