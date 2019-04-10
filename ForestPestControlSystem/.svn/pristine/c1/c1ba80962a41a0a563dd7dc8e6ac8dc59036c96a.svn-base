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
	$("input[name=name]").on("blur",function(){
		judge($(this),"请输入名字");
	});
	$("input[name=bithday]").on("blur",function(){
		judge($(this),"请输入出生日期");
	});

	$("input[name=expertise]").on("blur",function(){
		judge($(this),"请输入专长");
	});
	$("input[name=post]").on("blur",function(){
		judge($(this),"请输入职位");
	});
	$("input[name=phone]").on("blur",function(){
		judge($(this),"请输入电话");
	});
	$("input[name=workUnit]").on("blur",function(){
		judge($(this),"请输入工作地址");
	});
	$("input[name=path]").on("blur",function(){
		judge($(this),"请输入联系地址");
	});
	$("input[name=email]").on("blur",function(){
		judge($(this),"请输入邮箱");
	});
    $(function(){
    	$("#add").click(function(){
    		var falg = true;
    		var name = $("input[name=name]").val();
    		var bithday = $("input[name=bithday]").val();
    		var uploadImgFile = $("input[name=uploadImgFile]").val();
    		var expertise = $("input[name=expertise]").val();
    		var post = $("input[name=post]").val();
    		var phone = $("input[name=phone]").val();
    		var workUnit = $("input[name=workUnit]").val();
    		var path = $("input[name=path]").val();
    		var email = $("input[name=email]").val();
    		if(name == "" || name == null){
    			$("input[name=name]").blur();
				falg = false;
			}
    		if(bithday == "" || bithday == null){
				$("input[name=bithday]").blur();
				falg = false;
			}
    		if($("input[name=uploadImgFile]").val() != "" && $("input[name=uploadImgFile]").val() != null){
    			$(".file-caption").css({
    				"border": "1px solid gainsboro"
    			});
    		}else{
    			$(".file-caption").css({
    				"border": "1px solid red"
    			});
    			falg = false;
    		}

    		
    		if(expertise == "" || expertise == null){
				$("input[name=expertise]").blur();
				falg = false;
			}
    		if(post == "" || post == null){
				$("input[name=post]").blur();
				falg = false;
			}
    		if(phone == "" || phone == null){
				$("input[name=phone]").blur();
				falg = false;
			}else{
				var reg = /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;
				if(!reg.test(phone)){
					falg = false;
					$("input[name=phone]").val("");
					$("input[name=phone]").attr("placeholder","电话格式错误");
					$("input[name=phone]").css({
						"border": "1px solid red"
					});
				}
			}
    		if(workUnit == "" || workUnit == null){
				$("input[name=workUnit]").blur();
				falg = false;
			}
    		if(path == "" || path == null){
				$("input[name=path]").blur();
				falg = false;
			}
    		if(email == "" || email == null){
				$("input[name=email]").blur();
				falg = false;
			}else{
				var re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
				if(!re.test(email)){
					falg = false;
					$("input[name=email]").val("");
					$("input[name=email]").attr("placeholder","email邮箱格式错误");
					$("input[name=email]").css({
						"border": "1px solid red"
					});
				}
			}
			
    		if(falg){
				$(".form-horizontal").submit();
			}
    	});
    	
    	
        $('#file-pic1').fileinput({

            //初始化上传文件框
            language: "zh",//配置语言
            showPreview: false,//是否显示预览
            showUpload: true, //显示整体上传的按钮
            showRemove: false,//显示整体删除的按钮
            uploadAsync: false,//默认异步上传
//            uploadLabel: "上传",//设置整体上传按钮的汉字
            removeLabel: "移除",//设置整体删除按钮的汉字
            uploadClass: "btn btn-primary",//设置上传按钮样式
            showCaption: true,//是否显示标题initialCaption:"请选择图片",
            dropZoneEnabled: false,//是否显示拖拽区域
            showUpload: false,//是否显示上传按钮
//                    uploadUrl: getPath('/gz/tool/toolAction/uploadImgFile'),//这个是配置上传调取的后台地址，本项目是SSM搭建的
            maxFileSize : 9999,//文件大小限制
            maxFileCount: 1,//允许最大上传数，可以多个，
            enctype: 'multipart/form-data',
            allowedFileExtensions : ["jpg", "png","gif","docx","zip","xlsx","txt"],/*上传文件格式限制*/
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
            showBrowse: true,
            browseOnZoneClick: true,
            initialCaption: "请选择上传图片",//输入提示
            slugCallback : function(filename) {
                return filename.replace('(', '_').replace(']', '_');
            }
        });
    });