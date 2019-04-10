function judge(obj,str){
		var my = obj;
		if(my.val() != "" && my.val() != null){
			my.css({
				"border": "1px solid gainsboro"
			});
		}else{
			my.attr("placeholder",str);
			my.css({
				"border": "1px solid red"
			});
		}
	}
	$(function(){
		$("input[name=newPhone]").on("blur",function(){
			judge($(this),"请输入电话")
		});
		$("input[name=newPost]").on("blur",function(){
			judge($(this),"请输入职务")
		});
		$("input[name=newWorkUnit]").on("blur",function(){
			judge($(this),"请输入工作地址")
		});
		$("input[name=newEmail]").on("blur",function(){
			judge($(this),"请输入邮箱")
		});
		
		$("#sure").click(function(){
			var chonse = $("#id").val();
			falg = false;
			var falg = true;
			var newPost = $("input[name=newPost]").val();
			var newPhone = $("input[name=newPhone]").val();
			var newWorkUnit = $("input[name=newWorkUnit]").val();
			var newEmail = $("input[name=newEmail]").val();
			if(newPost == "" || newPost == null){
				$("input[name=newPost]").blur();
				falg = false;
			}
			if(newPhone == "" || newPhone == null){
				$("input[name=newPhone]").blur();		
				falg = false;
			}else{
				var reg = /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;
				if(!reg.test(newPhone)){
					falg = false;
					$("input[name=newPhone]").val("");
					$("input[name=newPhone]").attr("placeholder","电话格式错误");
					$("input[name=newPhone]").css({
						"border": "1px solid red"
					});
				}
			}
			if(newWorkUnit == "" || newWorkUnit == null){
				$("input[name=newWorkUnit]").blur();
				falg = false;
			}
			if(newEmail == "" || newEmail == null){
				$("input[name=newEmail]").blur();
				falg = false;
			}else{
				var re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
				if(!re.test(newEmail)){
					falg = false;
					$("input[name=newEmail]").val("");
					$("input[name=newEmail]").attr("placeholder","email邮箱格式错误");
					$("input[name=newEmail]").css({
						"border": "1px solid red"
					});
				}
			}
			if(falg){
				input = $("<input type='hidden' name='id' value="+chonse+">");
				$(".form-horizontal").append(input);
				$(".form-horizontal").attr("action","specialistUpdate");
				$(".form-horizontal").submit();
			}else{
				return false;
			}
		});
	});