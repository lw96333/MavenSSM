$(function(){
/*$("input[name=userName]").blur(function(){

			if($(this).val() == ""){
				$("input[name=userName]").css("border","1px red solid");
				$("input[name=userName]").attr("placeholder","账号不能为空！");
			}else{
				$("input[name=userName]").css("border","1px #DCDCDC solid");
				$("input[name=userName]").attr("placeholder","账号");
			}
		});*/
	
//电话号码验证
	 $("#phone").blur(function(){
		 if(!(/^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/.test($("#phone").val().trim()))){
			
			 $("#phone").attr("placeholder","电话格式不正确！");
			 $("#phone").css("border","1px red solid");
				
			}else{
				$("#phone").css("border","1px #DCDCDC solid");
			}
	 })
	 //登录密码验证
	 $("#enterpriepwd").blur(function(){
		 if(!(/\w{6,12}/.test($("#enterpriepwd").val().trim()))){
				
			 $("#enterpriepwd").attr("placeholder","密码为6-12位字母或数字！");
			 $("#enterpriepwd").css("border","1px red solid");
			}else{
				$("#enterpriepwd").css("border","1px #DCDCDC solid");
			}
	 })
	 
	 //楼层验证
	
	 $("#floor").blur(function(){
		 if(!(/^\d{1,3}$/.test($("#floor").val().trim()))){
			 $("#floor").attr("placeholder","楼层需为1-3位数字！");
			 $("#floor").css("border","1px red solid");
			
			}else{
				$("#floor").css("border","1px #DCDCDC solid");
			}
	 })
	  //登录名验证
	 $("#name").blur(function(){
		 if(!(/\w{2,8}/.test($("#name").val().trim()))){
			 $("#name").attr("placeholder","登录名为2-8位字母或数字！");
			 $("#name").css("border","1px red solid");
			
			}else{
				$("#name").css("border","1px #DCDCDC solid");
			}
	 })
	  //企业联系人验证^[\u4E00-\u9FA5A-Za-z]+$ 中文和英文
	 $("#contactperson").blur(function(){
		 if(!(/^[\u4E00-\u9FA5A-Za-z]+$/.test($("#contactperson").val().trim()))){
			 $("#contactperson").attr("placeholder","只能输入中文和英文！");
			 $("#contactperson").css("border","1px red solid");
			
			}else{
				$("#contactperson").css("border","1px #DCDCDC solid");
			}
	 })
	  //企业名称验证
	 $("#enterpriename").blur(function(){
		 if(!(/^[\u4E00-\u9FA5A-Za-z]+$/.test($("#enterpriename").val().trim()))){
			 $("#enterpriename").attr("placeholder","只能输入中文和英文！");
			 $("#enterpriename").css("border","1px red solid");
			
			}else{
				$("#enterpriename").css("border","1px #DCDCDC solid");
			}
	 })
})
